class Solution:
    def countPaths(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        mod = 10 ** 9 + 7
        directions = [[0, 1], [0, -1], [1, 0], [-1, 0]]
        
        # Initialize dp, 1 stands for the path made by a cell itself.
        dp = [[1] * n for _ in range(m)]

        # Sort all cells by value.
        cell_list = [[i, j] for i in range(m) for j in range(n)]
        cell_list.sort(key = lambda x: grid[x[0]][x[1]])
        
        # Iterate over the sorted cells, for each cell grid[i][j]: 
        for i, j in cell_list:
            # Check its four neighbor cells, if a neighbor cell grid[curr_i][curr_j] has a
            # larger value, increment dp[curr_i][curr_j] by dp[i][j]
            for di, dj in directions:
                curr_i, curr_j = i + di, j + dj
                if 0 <= curr_i < m and 0 <= curr_j < n and grid[curr_i][curr_j] > grid[i][j]:
                    dp[curr_i][curr_j] += dp[i][j]
                    dp[curr_i][curr_j] %= mod
        
        # Sum over dp[i][j].
        return sum(sum(row) % mod for row in dp) % mod