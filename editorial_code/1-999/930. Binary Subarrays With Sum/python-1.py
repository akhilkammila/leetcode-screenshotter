class Solution(object):
    def numSubarraysWithSum(self, A, S):
        P = [0]
        for x in A: P.append(P[-1] + x)
        count = collections.Counter()

        ans = 0
        for x in P:
            ans += count[x]
            count[x + S] += 1

        return ans