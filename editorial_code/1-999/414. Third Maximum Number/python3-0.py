class Solution:
    def thirdMax(self, nums: List[int]) -> int:
        # Sort the array.
        nums.sort(reverse = True)
        
        elem_counted = 1
        prev_elem = nums[0]
        
        for index in range(len(nums)):
            # Current element is different from previous.
            if nums[index] != prev_elem:
                elem_counted += 1
                prev_elem = nums[index]
            
            # If we have counted 3 numbers then return current number.
            if elem_counted == 3:
                return nums[index]
        
        # We never counted 3 distinct numbers, return largest number.
        return nums[0]