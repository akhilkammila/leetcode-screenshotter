class Solution:
    def strangePrinter(self, s: str) -> int:
        n = len(s)
        dp = [[-1] * n for _ in range(n)]

        def solve(left, right):
            if dp[left][right] != -1:
                return dp[left][right]
            
            dp[left][right] = n
            j = -1
            
            for i in range(left, right):
                if s[i] != s[right] and j == -1:
                    j = i
                if j != -1:
                    dp[left][right] = min(dp[left][right], 1 + solve(j, i) + solve(i + 1, right))
                    
            if j == -1:
                dp[left][right] = 0
    
            return dp[left][right]

        return solve(0, n - 1) + 1