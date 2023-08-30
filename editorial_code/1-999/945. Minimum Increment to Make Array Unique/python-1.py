class Solution:
    def minIncrementForUnique(self, nums: List[int]) -> int:
        nums.sort()
        max_val = nums[-1]
        nums.append(len(nums) + max_val)

        moves = taken = 0
        for i in range(1, len(nums)):
            if nums[i - 1] == nums[i]:
                taken += 1
                moves -= nums[i]
            else:
                give = min(taken, nums[i] - nums[i - 1] - 1)
                moves += give * (give + 1) // 2 + give * nums[i - 1]
                taken -= give

        return moves