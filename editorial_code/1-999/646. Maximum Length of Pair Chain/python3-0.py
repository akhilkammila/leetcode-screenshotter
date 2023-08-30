class Solution:
    def longestPairChain(self, i: int, pairs: List[List[int]], n: int, memo: List[int]) -> int:
        if memo[i] != 0:
            return memo[i]
        memo[i] = 1
        for j in range(i + 1, n):
            if pairs[i][1] < pairs[j][0]:
                memo[i] = max(memo[i], 1 + self.longestPairChain(j, pairs, n, memo))
        return memo[i]

    def findLongestChain(self, pairs: List[List[int]]) -> int:
        n = len(pairs)
        pairs.sort()
        memo = [0] * n

        ans = 0
        for i in range(n):
            ans = max(ans, self.longestPairChain(i, pairs, n, memo))
        return ans