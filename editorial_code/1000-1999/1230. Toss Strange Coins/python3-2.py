class Solution(object):
    def probabilityOfHeads(self, prob, target):
        n = len(prob)
        dp = [0] * (target + 1)
        dp[0] = 1

        for i in range(1, n + 1):
            for j in range(target, 0, -1):
                dp[j] = dp[j - 1] * prob[i - 1] + dp[j] * (1 - prob[i - 1])
            dp[0] = dp[0] * (1 - prob[i - 1])

        return dp[target]