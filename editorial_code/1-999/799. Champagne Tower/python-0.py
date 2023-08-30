class Solution(object):
    def champagneTower(self, poured, query_row, query_glass):
        A = [[0] * k for k in xrange(1, 102)]
        A[0][0] = poured
        for r in xrange(query_row + 1):
            for c in xrange(r+1):
                q = (A[r][c] - 1.0) / 2.0
                if q > 0:
                    A[r+1][c] += q
                    A[r+1][c+1] += q

        return min(1, A[query_row][query_glass])