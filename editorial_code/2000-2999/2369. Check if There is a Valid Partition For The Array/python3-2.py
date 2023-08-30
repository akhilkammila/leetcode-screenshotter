class Solution:
    def validPartition(self, nums: List[int]) -> bool:
        n = len(nums)
        
        # Only record the most recent 3 indices
        dp = [True] + [False] * 2

        # Determine if the prefix array nums[0 ~ i] has a valid partition
        for i in range(n):
            dp_index = i + 1
            ans = False
            if i > 0 and nums[i] == nums[i - 1]:
                ans |= dp[(dp_index - 2) % 3]
            if i > 1 and nums[i] == nums[i - 1] == nums[i - 2]:
                ans |= dp[(dp_index - 3) % 3]
            if i > 1 and nums[i] == nums[i - 1] + 1 == nums[i - 2] + 2:
                ans |= dp[(dp_index - 3) % 3]
            dp[dp_index % 3] = ans

        return dp[n % 3]