class Solution(object):
    def isMonotonic(self, A):
        return (all(A[i] <= A[i+1] for i in xrange(len(A) - 1)) or
                all(A[i] >= A[i+1] for i in xrange(len(A) - 1)))