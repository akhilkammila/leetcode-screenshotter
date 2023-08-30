class Solution:
    def soupServings(self, n: int) -> float:
        m = ceil(n / 25)
        dp = collections.defaultdict(dict)

        def calculate_dp(i: int, j: int) -> float:
            if i <= 0 and j <= 0:
                return 0.5
            if i <= 0:
                return 1.0
            if j <= 0:
                return 0.0
            if i in dp and j in dp[i]:
                return dp[i][j]

            dp[i][j] = (
                calculate_dp(i - 4, j)
                + calculate_dp(i - 3, j - 1)
                + calculate_dp(i - 2, j - 2)
                + calculate_dp(i - 1, j - 3)
            ) / 4.0
            return dp[i][j]

        for k in range(1, m + 1):
            if calculate_dp(k, k) > 1 - 1e-5:
                return 1.0
        return calculate_dp(m, m)