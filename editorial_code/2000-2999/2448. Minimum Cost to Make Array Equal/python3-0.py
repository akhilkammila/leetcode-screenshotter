class Solution:
    def minCost(self, nums: List[int], cost: List[int]) -> int:
        # Sort integers by values.
        num_and_cost = sorted([num, c] for num, c in zip(nums, cost))
        n = len(cost)
        
        # Get the prefix sum array of the costs.
        prefix_cost = [0] * n
        prefix_cost[0] = num_and_cost[0][1]
        for i in range(1, n): 
            prefix_cost[i] = num_and_cost[i][1] + prefix_cost[i - 1]
        
        # Then we try every integer nums[i] and make every element equals nums[i],
        # Start with nums[0]
        total_cost = 0
        for i in range(1, n): 
            total_cost += num_and_cost[i][1] * (num_and_cost[i][0] - num_and_cost[0][0])
        answer = total_cost
        
        # Then we try nums[1], nums[2] and so on. The cost difference is made by the change of
        # two parts: 1. prefix sum of costs. 2. suffix sum of costs. 
        # During the iteration, record the minimum cost we have met.
        for i in range(1, n):
            gap = num_and_cost[i][0] - num_and_cost[i - 1][0]
            total_cost += prefix_cost[i - 1] * gap
            total_cost -= gap * (prefix_cost[n - 1] - prefix_cost[i - 1])
            answer = min(answer, total_cost)
            
        return answer