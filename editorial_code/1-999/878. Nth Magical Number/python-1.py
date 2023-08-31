class Solution(object):
    def nthMagicalNumber(self, N, A, B):
        from fractions import gcd
        MOD = 10**9 + 7
        L = A / gcd(A,B) * B

        def magic_below_x(x):
            # How many magical numbers are <= x?
            return x / A + x / B - x / L

        lo = 0
        hi = N * min(A, B)
        while lo < hi:
            mi = (lo + hi) / 2
            if magic_below_x(mi) < N:
                lo = mi + 1
            else:
                hi = mi

        return lo % MOD