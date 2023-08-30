class Solution:
    def probabilityOfHeads(self, prob: List[float], target: int) -> float:
        memo = {}

        def findProbability(index, target, n):
            # Return 0 if the target is less than zero because we have more heads
            # than we need.
            if target < 0:
                return 0
            # After tossing all of the coins, if we get the required number of heads,
            # return 1 to count this case, otherwise return 0.
            if index == n:
                if target == 0:
                    return 1
                else:
                    return 0

            if (index, target) in memo:
                return memo[index, target]

            memo[index, target] = findProbability(index + 1, target - 1, n) * prob[index] + \
                                  findProbability(index + 1, target, n) * (1 - prob[index])

            return memo[index, target]

        return findProbability(0, target, len(prob))