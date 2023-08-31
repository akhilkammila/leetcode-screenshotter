class Solution(object):
    def getIndex(self, reader):
        left = 0
        length = reader.length()
        while (length > 1):
            length //= 2;
            cmp = reader.compareSub(left, left + length - 1, left + length,
                                              left + length + length - 1)
            if cmp == 0:
                return left + length + length
            if cmp < 0:
                left += length
        return left