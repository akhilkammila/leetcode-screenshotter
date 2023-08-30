class Solution:
    def projectionArea(self, grid):
        N = len(grid)
        ans = 0

        for i in xrange(N):
            best_row = 0  # max of grid[i][j]
            best_col = 0  # max of grid[j][i]
            for j in xrange(N):
                if grid[i][j]: ans += 1  # top shadow
                best_row = max(best_row, grid[i][j])
                best_col = max(best_col, grid[j][i])

            ans += best_row + best_col

        return ans

        """ Alternative solution:
        ans = sum(map(max, grid))
        ans += sum(map(max, zip(*grid)))
        ans += sum(v > 0 for row in grid for v in row)
        """