class Solution(object):
    def smallestDistancePair(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        nums.sort()
        heap = [(nums[i + 1] - nums[i], i, i + 1) for i in xrange(len(nums) - 1)]
        heapq.heapify(heap)

        for _ in xrange(k):
            d, root, nei = heapq.heappop(heap)
            if nei + 1 < len(nums):
                heapq.heappush(heap, (nums[nei + 1] - nums[root], root, nei + 1))

        return d