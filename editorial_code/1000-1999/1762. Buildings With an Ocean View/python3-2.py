class Solution:
    def findBuildings(self, heights: List[int]) -> List[int]:
        n = len(heights)
        answer = []
        max_height = -1
        
        for current in reversed(range(n)):
            # If there is no building higher (or equal) than the current one to its right,
            # push it in the answer array.
            if max_height < heights[current]:
                answer.append(current)
            
                # Update max building till now.
                max_height = heights[current]
        
        answer.reverse()
        return answer