class Solution:
    def findMissingRanges(self, nums: List[int], lower: int, upper: int) -> List[List[int]]:
        n = len(nums)
        missing_ranges = []
        if n == 0:
            missing_ranges.append([lower, upper])
            return missing_ranges

        # Check for any missing numbers between the lower bound and nums[0].
        if lower < nums[0]:
            missing_ranges.append([lower, nums[0] - 1])

        # Check for any missing numbers between successive elements of nums.
        for i in range(n - 1):
            if nums[i + 1] - nums[i] <= 1:
                continue
            missing_ranges.append([nums[i] + 1, nums[i + 1] - 1])

        # Check for any missing numbers between the last element of nums and the upper bound.
        if upper > nums[n - 1]:
            missing_ranges.append([nums[n - 1] + 1, upper])

        return missing_ranges