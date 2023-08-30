class Solution:
    def strangePrinter(self, s: str) -> int:
        n = len(s)
        dp = [[n] * n for _ in range(n)]
        for length in range(1, n + 1):
            for left in range(n - length + 1):
                right = left + length - 1
                j = -1
                for i in range(left, right):
                    if s[i] != s[right] and j == -1:
                        j = i
                    if j != -1:
                        dp[left][right] = min(dp[left][right], 1 + dp[j][i] + dp[i + 1][right])
        
                if j == -1:
                    dp[left][right] = 0

        return dp[0][n - 1] + 1