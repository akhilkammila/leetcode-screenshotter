class Solution:
    def numMusicPlaylists(self, n: int, goal: int, k: int) -> int:
        MOD = 1_000_000_007
        dp = [[-1 for _ in range(n + 1)] for _ in range(goal + 1)]

        def number_of_playlists(i, j):
            # Base cases
            if i == 0 and j == 0:
                return 1
            if i == 0 or j == 0:
                return 0
            if dp[i][j] != -1:
                return dp[i][j]
            # DP transition: add a new song or replay an old one
            dp[i][j] = (number_of_playlists(i - 1, j - 1) * (n - j + 1)) % MOD
            if j > k:
                dp[i][j] += (number_of_playlists(i - 1, j) * (j - k)) % MOD
                dp[i][j] %= MOD
            return dp[i][j]

        return number_of_playlists(goal, n)