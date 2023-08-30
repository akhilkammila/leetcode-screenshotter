class Solution(object):
    def reorderedPowerOf2(self, N):
        count = collections.Counter(str(N))
        return any(count == collections.Counter(str(1 << b))
                   for b in xrange(31))