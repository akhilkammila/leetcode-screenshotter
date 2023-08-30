class Solution(object):
    def racecar(self, target):
        dp = [0, 1, 4] + [float('inf')] * target
        for t in xrange(3, target + 1):
            k = t.bit_length()
            if t == 2**k - 1:
                dp[t] = k
                continue
            for j in xrange(k - 1):
                dp[t] = min(dp[t], dp[t - 2**(k - 1) + 2**j] + k - 1 + j + 2)
            if 2**k - 1 - t < t:
                dp[t] = min(dp[t], dp[2**k - 1 - t] + k + 1)
        return dp[target]