class Solution(object):
    def xorGame(self, nums):
        return reduce(operator.xor, nums) == 0 or len(nums) % 2 == 0