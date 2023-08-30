class Solution:
    def validPartition(self, nums: List[int]) -> bool:
        n = len(nums)
        memo = {-1: True}

        # Determine if the prefix array nums[0 ~ i] has a valid partition
        def prefixIsValid(i):
            if i in memo:
                return memo[i]
            ans = False

            # Check 3 possibilities
            if i > 0 and nums[i] == nums[i - 1]:
                ans |= prefixIsValid(i - 2)
            if i > 1 and nums[i] == nums[i - 1] == nums[i - 2]:
                ans |= prefixIsValid(i - 3)
            if i > 1 and nums[i] == nums[i - 1] + 1 == nums[i - 2] + 2:
                ans |= prefixIsValid(i - 3)
            memo[i] = ans
            return ans

        return prefixIsValid(n - 1)