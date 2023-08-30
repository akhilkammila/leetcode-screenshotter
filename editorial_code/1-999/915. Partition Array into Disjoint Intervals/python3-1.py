class Solution:
    def partitionDisjoint(self, nums: List[int]) -> int:
        N = len(nums)
        min_right = [None] * N
        min_right[-1] = nums[-1]

        for i in range(N - 2, -1, -1):
            min_right[i] = min(min_right[i + 1], nums[i])

        curr_max = nums[0]
        for i in range(1, N):
            curr_max = max(curr_max, nums[i - 1])
            if curr_max <= min_right[i]:
                return i