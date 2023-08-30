class Solution:
    def minCost(self, nums: List[int], cost: List[int]) -> int:
        # Get the cost of making every element equals base.
        def get_cost(base):
            return sum(abs(base - num) * c for num, c in zip(nums, cost))
        
        # Initialize the left and the right boundary of the binary search.
        left, right = min(nums), max(nums)
        answer = get_cost(nums[0])
        
        # As shown in the previous picture, if F(mid) > F(mid + 1), then the minimum
        # is to the right of mid, otherwise, the minimum is to the left of mid.
        while left < right:
            mid = (left + right) // 2
            cost_1 = get_cost(mid)
            cost_2 = get_cost(mid + 1)
            answer = min(cost_1, cost_2)
            
            if cost_1 > cost_2:
                left = mid + 1
            else:
                right = mid
        
        return answer