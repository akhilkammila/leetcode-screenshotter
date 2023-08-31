class Solution:
    def minimumAverageDifference(self, nums: List[int]) -> int:
        n = len(nums)
        ans = -1
        min_avg_diff = math.inf
        curr_prefix_sum = 0
        
        # Get total sum of array.
        total_sum = 0
        for index in range(n):
            total_sum += nums[index]
        
        for index in range(n):
            curr_prefix_sum += nums[index]
            
            # Calculate average of left part of array, index 0 to i.
            left_part_average = curr_prefix_sum
            left_part_average //= (index + 1)
            
            # Calculate average of right part of array, index i+1 to n-1.
            right_part_average = total_sum - curr_prefix_sum
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