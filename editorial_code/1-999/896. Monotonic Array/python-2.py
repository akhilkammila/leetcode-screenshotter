class Solution(object):
    def isMonotonic(self, A):
        increasing = decreasing = True

        for i in xrange(len(A) - 1):
            if A[i] > A[i+1]:
                increasing = False
            if A[i] < A[i+1]:
                decreasing = False

        return increasing or decreasing