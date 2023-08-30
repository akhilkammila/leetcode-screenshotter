class Solution:
    def maximumScore(self, nums: List[int], multipliers: List[int]) -> int:

        # Number of Operations
        m = len(multipliers)

        def helper(left, right, op):
            if op == m:
                return 0

            return max(nums[left] * multipliers[op] + helper(left+1, right, op+1),
                       nums[right] * multipliers[op] + helper(left, right-1, op+1))

        return helper(0, len(nums)-1, 0)