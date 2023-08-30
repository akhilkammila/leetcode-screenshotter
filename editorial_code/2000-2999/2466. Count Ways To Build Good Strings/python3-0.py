class Solution:
    def countGoodStrings(self, low: int, high: int, zero: int, one: int) -> int:
        # Use dp[i] to record to number of good strings of length i.
        dp = [1] + [0] * (high)
        mod = 10 ** 9 + 7
        
        # Iterate over each length `end`.
        for end in range(1, high + 1):
            # check if the current string can be made by append zero `0`s or one `1`s.
            if end >= zero:
                dp[end] += dp[end - zero]
            if end >= one:
                dp[end] += dp[end - one]
            dp[end] %= mod
        
        # Add up the number of strings with each valid length [low ~ high].
        return sum(dp[low : high + 1]) % mod