class Solution:
    def zeroFilledSubarray(self, nums: List[int]) -> int:
        ans, num_subarray = 0, 0
        
        # Iterate over nums, if num = 0, it has 1 more zero-filled subarray
        # than the previous one, otherwise, it has 0 zero-filled subarray.
        for num in nums:
            if num == 0: 
                num_subarray += 1
            else: 
                num_subarray = 0
            ans += num_subarray
            
        return ans