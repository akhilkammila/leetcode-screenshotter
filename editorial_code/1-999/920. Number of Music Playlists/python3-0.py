class Solution:
    def numMusicPlaylists(self, n: int, goal: int, k: int) -> int:
        MOD = 10**9 + 7

        # Initialize the DP table
        dp = [[0 for _ in range(n + 1)] for _ in range(goal + 1)]
        dp[0][0] = 1

        for i in range(1, goal + 1):
            for j in range(1, min(i, n) + 1):
                # The i-th song is a new song
                dp[i][j] = dp[i - 1][j - 1] * (n - j + 1) % MOD
                # The i-th song is a song we have played before
                if j > k:
                    dp[i][j] = (dp[i][j] + dp[i - 1][j] * (j - k)) % MOD

        return dp[goal][n]