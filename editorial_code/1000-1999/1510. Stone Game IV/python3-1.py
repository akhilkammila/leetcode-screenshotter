class Solution:
    def winnerSquareGame(self, n: int) -> bool:
        dp = [False]*(n+1)
        for i in range(1, n+1):
            for k in range(1, int(i**0.5)+1):
                if dp[i-k*k] == False:
                    dp[i] = True
                    break
        return dp[n]