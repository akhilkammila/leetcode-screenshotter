class Solution(object):
    def sortArrayByParity(self, A):
        A.sort(key = lambda x: x % 2)
        return A