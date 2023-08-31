from sortedcontainers import SortedSet

class Solution:
    def thirdMax(self, nums: List[int]) -> int:
        # Sorted set to keep elements in sorted order.
        sorted_nums = SortedSet()
        
        # Iterate on all elements of 'nums' array.
        for num in nums:
            # Do not insert same element again.
            if num in sorted_nums:
                continue
            
            # If sorted set has 3 elements.
            if len(sorted_nums)== 3:
                # And the smallest element is smaller than current element.
                if sorted_nums[0] < num:
                    # Then remove the smallest element and push the current element.
                    sorted_nums.discard(sorted_nums[0])
                    sorted_nums.add(num)
            # Otherwise push the current element of nums array.
            else:
                sorted_nums.add(num)
        
        # If sorted set has three elements return the smallest among those 3.
        if len(sorted_nums) == 3:
            return sorted_nums[0]
        
        # Otherwise return the biggest element of nums array.
        return sorted_nums[-1]