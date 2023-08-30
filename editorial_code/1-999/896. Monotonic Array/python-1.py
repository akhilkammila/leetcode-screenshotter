class Solution(object):
    def isMonotonic(self, A):
        store = 0
        for i in xrange(len(A) - 1):
            c = cmp(A[i], A[i+1])
            if c:
                if c != store != 0:
                    return False
                store = c
        return True