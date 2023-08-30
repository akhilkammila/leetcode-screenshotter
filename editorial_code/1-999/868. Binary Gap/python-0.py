class Solution(object):
    def binaryGap(self, N):
        A = [i for i in xrange(32) if (N >> i) & 1]
        if len(A) < 2: return 0
        return max(A[i+1] - A[i] for i in xrange(len(A) - 1))