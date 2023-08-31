class Solution:
    def getAverages(self, nums: List[int], k: int) -> List[int]:
        averages = [-1] * len(nums)
        # When a single element is considered then its average will be the number itself only.
        if k == 0:
            return nums

        n = len(nums)

        # Any index will not have 'k' elements in it's left and right.
        if 2 * k + 1 > n:
            return averages

        # First get the sum of first window of the 'nums' arrray.
        window_sum = sum(nums[:2 * k + 1])
        averages[k] = window_sum // (2 * k + 1)

        # Iterate on rest indices which have at least 'k' elements 
        # on its left and right sides.
        for i in range(2 * k + 1, n):
            # We remove the discarded element and add the new element to get current window sum.
            # 'i' is the index of new inserted element, and
            # 'i - (window size)' is the index of the last removed element.
            window_sum = window_sum - nums[i - (2 * k + 1)] + nums[i]
            averages[i - k] = window_sum // (2 * k + 1)

        return averages