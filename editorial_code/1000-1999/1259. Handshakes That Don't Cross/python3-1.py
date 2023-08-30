class Solution:
    def numberOfWays(self, numPeople: int) -> int:
        m = 1000000007
        dp = [-1] * (numPeople // 2 + 1)
        dp[0] = 1

        def calculate_dp(i):
            if dp[i] != -1:
                return dp[i]
            dp[i] = 0
            for j in range(i):
                dp[i] += calculate_dp(j) * calculate_dp(i - j - 1)
            dp[i] %= m
            return dp[i]

        return calculate_dp(numPeople // 2)