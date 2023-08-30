class Solution(object):
    def matrixScore(self, A):
        R, C = len(A), len(A[0])

        colsums = [0] * C
        for r in xrange(R):
            for c in xrange(C):
                colsums[c] += A[r][c]

        ans = 0
        for r in xrange(1<<R):
            if r:
                trans = r ^ (r-1)
                for bit in xrange(R):
                    if (trans >> bit) & 1:
                        for c in xrange(C):
                            colsums[c] += -1 if A[bit][c] else +1
                            A[bit][c] ^= 1
            
            score = sum(max(x, R - x) * (1 << (C-1-c))
                        for c, x in enumerate(colsums))
            ans = max(ans, score)

        return ans