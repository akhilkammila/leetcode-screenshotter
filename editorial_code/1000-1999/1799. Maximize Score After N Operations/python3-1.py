class Solution:
    def maxScore(self, nums: List[int]) -> int:
        maxStates = 1 << len(nums) # 2^(nums array size)
        finalMask = maxStates - 1

        # 'dp[i]' stores max score we can get after picking remaining numbers represented by 'i'.
        dp = [0] * maxStates

        # Iterate on all possible states one-by-one.
        for state in range(finalMask, -1, -1):
            # If we have picked all numbers, we know we can't get more score as no number is remaining.
            if state == finalMask:
                dp[state] = 0
                continue

            numbersTaken = bin(state).count('1')
            pairsFormed = numbersTaken // 2
            # States representing even numbers are taken are only valid.
            if numbersTaken % 2:
                continue

            # We have picked 'pairsFormed' pairs, we try all combinations of one more pair now.
            # We iterate on two numbers using two nested for loops.
            for firstIndex in range(len(nums)):
                for secondIndex in range(firstIndex + 1, len(nums)):
                    # We only choose those numbers which were not already picked.
                    if (state >> firstIndex & 1) == 1 or (state >> secondIndex & 1) == 1:
                        continue
                    currentScore = (pairsFormed + 1) * math.gcd(nums[firstIndex], nums[secondIndex])
                    stateAfterPickingCurrPair = state | (1 << firstIndex) | (1 << secondIndex)
                    remainingScore = dp[stateAfterPickingCurrPair]
                    dp[state] = max(dp[state], currentScore + remainingScore)

        # Returning score we get from 'n' remaining numbers of array.
        return dp[0]