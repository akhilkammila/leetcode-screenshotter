class Solution:
    def equalPairs(self, grid: List[List[int]]) -> int:
        count = 0
        n = len(grid)
        
        # Keep track of the frequency of each row.
        row_counter = collections.Counter(tuple(row) for row in grid)

        # Add up the frequency of each column in map.
        for c in range(n):
            col = [grid[i][c] for i in range(n)]
            count += row_counter[tuple(col)]

            
        return count