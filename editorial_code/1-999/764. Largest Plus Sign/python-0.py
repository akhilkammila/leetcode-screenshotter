class Solution(object):
    def orderOfLargestPlusSign(self, N, mines):
        banned = {tuple(mine) for mine in mines}
        ans = 0
        for r in xrange(N):
            for c in xrange(N):
                k = 0
                while (k <= r < N-k and k <= c < N-k and
                        (r-k, c) not in banned and
                        (r+k, c) not in banned and
                        (r, c-k) not in banned and
                        (r, c+k) not in banned):
                    k += 1
                ans = max(ans, k)
        return ans