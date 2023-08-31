class Solution:
    def findBuildings(self, heights: List[int]) -> List[int]:
        n = len(heights)
        answer = []
        
        # Monotonically decreasing stack.
        stack = []
        for current in reversed(range(n)):
            # If the building to the right is smaller, we can pop it.
            while stack and heights[stack[-1]] < heights[current]:
                stack.pop()
            
            # If the stack is empty, it means there is no building to the right 
            # that can block the view of the current building.
            if not stack:
                answer.append(current)
            
            # Push the current building in the stack.
            stack.append(current)
        
        answer.reverse()
        return answer