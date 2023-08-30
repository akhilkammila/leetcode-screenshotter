class Solution(object):
    def hasAlternatingBits(self, n):
        bits = bin(n)
        return all(bits[i] != bits[i+1]
                   for i in xrange(len(bits) - 1))