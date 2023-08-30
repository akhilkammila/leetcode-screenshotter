class Solution:
    def findLongestChain(self, pairs: List[List[int]]) -> int:
        n = len(pairs)
        pairs.sort()
        dp = [1] * n
        ans = 1

        for i in range(n - 1, -1, -1):
            for j in range(i + 1, n):
                if pairs[i][1] < pairs[j][0]:
                    dp[i] = max(dp[i], 1 + dp[j])
            ans = max(ans, dp[i])
        return ans