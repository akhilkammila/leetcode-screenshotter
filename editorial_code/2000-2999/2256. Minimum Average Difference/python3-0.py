class Solution:
    def minimumAverageDifference(self, nums: List[int]) -> int:
        n = len(nums)
        ans = -1
        min_avg_diff = math.inf
        
        for index in range(n):
            # Calculate average of left part of array, index 0 to i.
            left_part_average = 0
            for i in range(index + 1):
                left_part_average += nums[i]
            left_part_average //= (index + 1)
            
            # Calculate average of right part of array, index i+1 to n-1.
            right_part_average = 0
            for j in range(index + 1, n):
                right_part_average += nums[j]
        
            # If right part have 0 elements, then we don't divide by 0.
            if index != n - 1:
                right_part_average //= (n - index - 1)
            
            curr_difference = abs(left_part_average - right_part_average)
            
            # If current difference of averages is smaller,
            # then current index can be our answer.
            if curr_difference < min_avg_diff:
                min_avg_diff = curr_difference
                ans = index
                
        return ans