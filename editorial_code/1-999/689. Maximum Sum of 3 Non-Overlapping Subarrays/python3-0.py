class Solution:
    def maxSumOfThreeSubarrays(self, nums: List[int], k: int) -> List[int]:
        W = [] #array of sums of windows
        curr_sum = 0
        for i, x in enumerate(nums):
            curr_sum += x
            if i >= k: 
                curr_sum -= nums[i - k]
            if i >= k - 1: 
                W.append(curr_sum)

        left = [0] * len(W)
        best = 0
        for i in range(len(W)):
            if W[i] > W[best]:
                best = i
            left[i] = best

        right = [0] * len(W)
        best = len(W) - 1
        for i in range(len(W) - 1, -1, -1):
            if W[i] >= W[best]:
                best = i
            right[i] = best

        ans = None
        for j in range(k, len(W) - k):
            i, l = left[j - k], right[j + k]
            if ans is None or (W[i] + W[j] + W[l] > W[ans[0]] + W[ans[1]] + W[ans[2]]):
                ans = i, j, l
        return ans