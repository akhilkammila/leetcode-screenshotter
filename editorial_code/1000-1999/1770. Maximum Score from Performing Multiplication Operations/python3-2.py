class Solution:
    def maximumScore(self, nums: List[int], multipliers: List[int]) -> int:

        # Number of Operations
        m = len(multipliers)

        # For Right Pointer
        n = len(nums)

        memo = {}

        def dp(op, left):
            if op == m:
                return 0

            # If already computed, return
            if (op, left) in memo:
                return memo[(op, left)]

            l = nums[left] * multipliers[op] + dp(op+1, left+1)
            r = nums[(n-1)-(op-left)] * multipliers[op] + dp(op+1, left)

            memo[(op, left)] = max(l, r)

            return memo[(op, left)]

        # Zero operation done in the beginning
        return dp(0, 0)
 