class Solution(object):
    def numSubarraysWithSum(self, A, S):
        indexes = [-1] + [ix for ix, v in enumerate(A) if v] + [len(A)]
        ans = 0

        if S == 0:
            for i in xrange(len(indexes) - 1):
                # w: number of zeros between two consecutive ones
                w = indexes[i+1] - indexes[i] - 1
                ans += w * (w+1) / 2
            return ans

        for i in xrange(1, len(indexes) - S):
            j = i + S - 1
            left = indexes[i] - indexes[i-1]
            right = indexes[j+1] - indexes[j]
            ans += left * right
        return ans