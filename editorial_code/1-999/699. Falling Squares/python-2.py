class Solution(object):
    def fallingSquares(self, positions):
        #Coordinate Compression
        #index = ...

        heights = [0] * len(index)
        def query(L, R):
            return max(heights[i] for i in xrange(L, R+1))

        def update(L, R, h):
            for i in xrange(L, R+1):
                heights[i] = max(heights[i], h)

        best = 0
        ans = []
        for left, size in positions:
            L = index[left]
            R = index[left + size - 1]
            h = query(L, R) + size
            update(L, R, h)
            best = max(best, h)
            ans.append(best)

        return ans