class Solution:
    def maximumNumberOfOnes(self, width: int, height: int, sideLength: int, maxOnes: int) -> int:
        count = []
        
        for r in range(sideLength):
            for c in range(sideLength):
                num = (1 + (width - c - 1) // sideLength) * (1 + (height - r - 1) // sideLength)
                count.append(num)
                
        count.sort(reverse=True)
        return sum(count[:maxOnes])