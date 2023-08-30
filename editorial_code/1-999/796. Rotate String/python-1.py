class Solution(object):
    def rotateString(self, A, B):
        return len(A) == len(B) and B in A+A