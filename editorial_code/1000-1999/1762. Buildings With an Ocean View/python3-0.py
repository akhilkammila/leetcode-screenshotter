class Solution:
    def findBuildings(self, heights: List[int]) -> List[int]:
        n = len(heights)
        answer = []

        for current in range(n):
            # If the current building is taller, 
            # it will block the shorter building's ocean view to its left.
            # So we pop all the shorter buildings that have been added before.
            while answer and heights[answer[-1]] <= heights[current]:
                answer.pop()
            answer.append(current)
            
        return answer