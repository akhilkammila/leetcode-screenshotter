class Solution:
    def findShortestWay(self, maze: List[List[int]], ball: List[int], hole: List[int]) -> str:
        def valid(row, col):
            return 0 <= row < m and 0 <= col < n and maze[row][col] == 0
        
        def get_neighbors(row, col):
            directions = [(0, -1, 'l'), (-1, 0, 'u'), (0, 1, 'r'), (1, 0, 'd')]
            neighbors = []
            
            for dy, dx, direction in directions:
                curr_row = row
                curr_col = col
                dist = 0
                
                while valid(curr_row + dy, curr_col + dx):
                    curr_row += dy
                    curr_col += dx
                    dist += 1
                    if [curr_row, curr_col] == hole:
                        break
                    
                neighbors.append((curr_row, curr_col, dist, direction))
                
            return neighbors

        m = len(maze)
        n = len(maze[0])
        heap = [(0, "", ball[0], ball[1])]
        seen = set()
        
        while heap:
            curr_dist, path, row, col = heappop(heap)
            
            if (row, col) in seen:
                continue
            
            if [row, col] == hole:
                return path
            
            seen.add((row, col))
            
            for next_row, next_col, dist, direction in get_neighbors(row, col):
                heappush(heap, (curr_dist + dist, path + direction, next_row, next_col))

        return "impossible"