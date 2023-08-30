class Solution(object):
    def arraySign(self, nums):
        countNegativeNumbers = 0
        for num in nums:
            if num == 0:
                return 0
            if num < 0:
                countNegativeNumbers = countNegativeNumbers + 1

        if countNegativeNumbers %2 == 0:
            return 1
        return -1