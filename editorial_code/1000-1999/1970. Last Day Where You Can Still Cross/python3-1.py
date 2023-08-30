class Solution:
    def canCross(self, row, col, cells, day):
        grid = [[0] * col for _ in range(row)]
        
        for r, c in cells[:day]:
            grid[r - 1][c - 1] = 1
            
        def dfs(r, c):
            if r < 0 or r >= row or c < 0 or c >= col or grid[r][c] != 0:
                return False
            if r == row - 1:
                return True
            grid[r][c] = -1
            for dr, dc in [(1, 0), (-1, 0), (0, 1), (0, -1)]:
                if dfs(r + dr, c + dc):
                    return True
            return False
        
        for i in range(col):
            if grid[0][i] == 0 and dfs(0, i):
                return True

        return False
    
    
    def latestDayToCross(self, row: int, col: int, cells: List[List[int]]) -> int:
        left, right = 1, row * col
        
        while left < right:
            mid = right - (right - left) // 2
            if self.canCross(row, col, cells, mid):
                left = mid
            else:
                right = mid - 1
                
        return left