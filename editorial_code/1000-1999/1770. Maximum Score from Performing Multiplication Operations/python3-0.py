class Solution:
    def maximumScore(self, nums, multipliers):

        # Number of Operations
        m = len(multipliers)

        def helper(nums, op):
            if op == m:
                return 0

            # Returning Maximum of Two
            # In first parameter we have chosen nums[start], thus subproblem will be nums excluding nums[start]
            # In second parameter we have chosen nums[end], thus subproblem will be nums excluding nums[end]
            return max(nums[0] * multipliers[op] + helper(nums[1:], op+1),
                       nums[-1] * multipliers[op] + helper(nums[:-1], op+1))

        return helper(nums, 0)