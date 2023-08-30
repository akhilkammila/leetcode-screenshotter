from heapq import heappop, heappush
class Solution:
    def smallestDistancePair(self, nums: List[int], k: int) -> int:
        n = len(nums)
        nums.sort()
        heap = [(nums[i + 1] - nums[i], i, i + 1) for i in range(n - 1)]
        heapify(heap)

        for _ in range(k):
            d, root, nei = heappop(heap)
            if nei + 1 < n:
                heappush(heap, (nums[nei + 1] - nums[root], root, nei + 1))

        return d