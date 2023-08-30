class Solution:
    def findSubsequences(self, nums: List[int]) -> List[List[int]]:
        n = len(nums)
        result = set()
        for bitmask in range(1, 1 << n):
            # build the sequence
            sequence = [nums[i] for i in range(n) if (bitmask >> i) & 1]
            # check if its length is at least 2, and it is increasing
            if len(sequence) >= 2 and all([sequence[i] <= sequence[i + 1]
                                          for i in range(len(sequence) - 1)]):
                result.add(tuple(sequence))
        return result