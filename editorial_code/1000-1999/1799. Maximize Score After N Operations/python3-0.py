class Solution:
    def backtrack(self, nums: List[int], mask: int, pairsPicked: int, memo: List[int]) -> int:
        # If we have picked all the numbers from 'nums' array, we can't get more score.
        if 2 * pairsPicked == len(nums):
            return 0

        # If we already solved this sub-problem then return the stored result.
        if memo[mask] != -1:
            return memo[mask]

        maxScore = 0

        # Iterate on 'nums' array to pick the first and second number of the pair.
        for firstIndex in range(len(nums)):
            for secondIndex in range(firstIndex + 1, len(nums)):

                # If the numbers are same, or already picked, then we move to next number.
                if (mask >> firstIndex) & 1 == 1 or (mask >> secondIndex) & 1 == 1:
                    continue

                # Both numbers are marked as picked in this new mask.
                newMask = mask | (1 << firstIndex) | (1 << secondIndex)

                # Calculate score of current pair of numbers, and the remaining array.
                currScore = (pairsPicked + 1) * math.gcd(nums[firstIndex], nums[secondIndex])
                remainingScore = self.backtrack(nums, newMask, pairsPicked + 1, memo)

                # Store the maximum score.
                maxScore = max(maxScore, currScore + remainingScore)
                # We will use old mask in loop's next interation,
                # means we discarded the picked number and backtracked.

        # Store the result of the current sub-problem.
        memo[mask] = maxScore
        return maxScore
    
    def maxScore(self, nums: List[int]) -> int:
        memoSize = 1 << len(nums)  # 2^(nums array size)
        memo = [-1] * memoSize
        return self.backtrack(nums, 0, 0, memo)