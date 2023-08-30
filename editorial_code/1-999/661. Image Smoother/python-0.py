class Solution(object):
    def imageSmoother(self, M):
        R, C = len(M), len(M[0])
        ans = [[0] * C for _ in M]

        for r in xrange(R):
            for c in xrange(C):
                count = 0
                for nr in (r-1, r, r+1):
                    for nc in (c-1, c, c+1):
                        if 0 <= nr < R and 0 <= nc < C:
                            ans[r][c] += M[nr][nc]
                            count += 1
                ans[r][c] /= count

        return ans