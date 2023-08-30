class Solution:
    def findSubsequences(self, nums: List[int]) -> List[List[int]]:
        result = set()
        sequence = []

        def backtrack(index):
            # if we have checked all elements
            if index == len(nums):
                if len(sequence) >= 2:
                    result.add(tuple(sequence))
                return
            # if the sequence remains increasing after appending nums[index]
            if not sequence or sequence[-1] <= nums[index]:
                # append nums[index] to the sequence
                sequence.append(nums[index])
                # call recursively
                backtrack(index + 1)
                # delete nums[index] from the end of the sequence
                sequence.pop()
            # call recursively not appending an element
            backtrack(index + 1)
        backtrack(0)
        return result