class Solution:
    def soupServings(self, n: int) -> float:
        m = ceil(n / 25)
        dp = {}

        def calculate_dp(i, j):
            return (dp[max(0, i - 4)][j] + dp[max(0, i - 3)][j - 1] +
                    dp[max(0, i - 2)][max(0, j - 2)]
                    + dp[i - 1][max(0, j - 3)]) / 4

        dp[0] = {0: 0.5}
        for k in range(1, m + 1):
            dp[0][k] = 1
            dp[k] = {0: 0}
            for j in range(1, k + 1):
                dp[j][k] = calculate_dp(j, k)
                dp[k][j] = calculate_dp(k, j)
            if dp[k][k] > 1 - 1e-5:
                return 1
        return dp[m][m]