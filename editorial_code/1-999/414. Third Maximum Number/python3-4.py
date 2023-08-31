class Solution:
    def thirdMax(self, nums: List[int]) -> int:
        firstMax = (-1, False)
        secondMax = (-1, False)
        thirdMax = (-1, False)
        
        for num in nums:
            # If current number is already stored, skip it.
            if (firstMax[1] and firstMax[0] == num) or \
                (secondMax[1] and secondMax[0] == num) or \
                (thirdMax[1] and thirdMax[0] == num):
                continue
            
            # If we never stored any variable in firstMax
            # or curr num is bigger than firstMax, then curr num is the biggest number.
            if not firstMax[1] or firstMax[0] <= num:
                thirdMax = secondMax
                secondMax = firstMax
                firstMax = (num, True)
            # If we never stored any variable in secondMax
            # or curr num is bigger than secondMax, then curr num is 2nd biggest number.
            elif not secondMax[1] or secondMax[0] <= num:
                thirdMax = secondMax
                secondMax = (num, True)
            # If we never stored any variable in thirdMax
            # or curr num is bigger than thirdMax, then curr num is 3rd biggest number.
            elif not thirdMax[1] or thirdMax[0] <= num:
                thirdMax = (num, True)
        
        # If third max was never updated, it means we don't have 3 distinct numbers.
        if not thirdMax[1]:
            return firstMax[0]
        
        return thirdMax[0]