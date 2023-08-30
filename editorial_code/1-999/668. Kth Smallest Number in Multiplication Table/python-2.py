class Solution(object):
    def findKthNumber(self, m, n, k):
        def enough(x):
            count = 0
            for i in xrange(1, m+1):
                count += min(x // i, n)
            return count >= k

        lo, hi = 1, m * n
        while lo < hi:
            mi = (lo + hi) / 2
            if not enough(mi):
                lo = mi + 1
            else:
                hi = mi
        return lo