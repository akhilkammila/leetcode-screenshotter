class Solution:
    def stoneGameII(self, piles: List[int]) -> int:
        n = len(piles)
        dp = [[[-1] * (n + 1) for i in range(n + 1)] for p in range(0, 2)]

        def f(p, i, m):
            if i == n:
                return 0
            if dp[p][i][m] != -1:
                return dp[p][i][m]
            res = 1000000 if p == 1 else -1
            s = 0
            for x in range(1, min(2 * m, n - i) + 1):
                s += piles[i + x - 1]
                if p == 0:
                    res = max(res, s + f(1, i + x, max(m, x)))
                else:
                    res = min(res, f(0, i + x, max(m, x)))
            dp[p][i][m] = res
            return res
        
        return f(0, 0, 1)