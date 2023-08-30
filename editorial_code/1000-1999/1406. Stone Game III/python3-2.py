class Solution:
    def stoneGameIII(self, stoneValue: List[int]) -> str:
        n = len(stoneValue)
        not_computed = 10**9
        dp = [not_computed] * (n + 1)

        def f(i):
            if i == n:
                return 0
            if dp[i] != not_computed:
                return dp[i]
            dp[i] = stoneValue[i] - f(i + 1)
            if i + 2 <= n:
                dp[i] = max(dp[i], stoneValue[i] + stoneValue[i + 1] - f(i + 2))
            if i + 3 <= n:
                dp[i] = max(dp[i], stoneValue[i] + stoneValue[i + 1]
                            + stoneValue[i + 2] - f(i + 3))
            return dp[i]

        dif = f(0)
        if dif > 0:
            return "Alice"
        if dif < 0:
            return "Bob"
        return "Tie"