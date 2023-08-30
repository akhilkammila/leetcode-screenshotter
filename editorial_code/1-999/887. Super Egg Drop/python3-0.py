class Solution:
    def superEggDrop(self, K: int, N: int) -> int:
        @lru_cache(None)
        def dp(k, n):
            if n == 0:
                return 0
            if k == 1:
                return n
            lo, hi = 1, n
            # keep a gap of 2 X values to manually check later
            while lo + 1 < hi:
                x = (lo + hi) // 2
                t1 = dp(k-1, x-1)
                t2 = dp(k, n-x)

                if t1 < t2:
                    lo = x
                elif t1 > t2:
                    hi = x
                else:
                    lo = hi = x
            return 1 + min(max(dp(k-1, x-1), dp(k, n-x))for x in (lo, hi))

        return dp(K, N)