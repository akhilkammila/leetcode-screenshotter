class Solution:
    def equalPairs(self, grid: List[List[int]]) -> int:
        count = 0
        n = len(grid)
        
        # Check each row r against each column c.
        for r in range(n):
            for c in range(n):
                match = True
                
                # Iterate over row r and column c.
                for i in range(n):
                    if grid[r][i] != grid[i][c]:
                        match = False
                        break
                        
                # If row r equals column c, increment count by 1.
                count += int(match)
                    
        return count