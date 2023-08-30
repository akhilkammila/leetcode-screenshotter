class Solution:
    def numberOfArrays(self, s: str, k: int) -> int:
        m, n = len(s), len(str(k))
        mod = 10 ** 9 + 7
        # dp[i % (n + 1)] records the number of arrays that can be printed as
        # the prefix substring s[0 ~ i - 1]
        dp = [1] + [0] * n
        
        # Iterate over every digit, for each digit s[start]:
        for start in range(m):
            if s[start] == '0':
                dp[start % (n + 1)] = 0
                continue
            
            # Iterate over ending digit end and find all valid numbers 
            # s[start ~ end].
            for end in range(start, m):
                if int(s[start : end + 1]) > k:
                    break

                # If s[start ~ end] is valid, increment dp[(end + 1) % (n + 1)] by dp[start].
                dp[(end + 1) % (n + 1)] += dp[start % (n + 1)]
                dp[(end + 1) % (n + 1)] %= mod
            
            # Set dp[start % (n + 1)] as 0.
            dp[start % (n + 1)] = 0

        return dp[m % (n + 1)]