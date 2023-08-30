class Solution:
    def numberOfArrays(self, s: str, k: int) -> int:
        m, n = len(s), len(str(k))
        mod = 10 ** 9 + 7
        
        # dp[i] records the number of arrays that can be printed as
        # the prefix substring s[0 ~ i - 1]
        dp = [1] + [0] * m
        
        # Iterate over every digit, for each digit s[start]:
        for start in range(m):
            if s[start] == '0':
                continue            
            count = 0
    
            # Iterate over ending digit end and find all valid numbers 
            # s[start ~ end].
            for end in range(start, m):  
                curr_number = s[start:end + 1]
                if int(curr_number) > k:
                    break
                
                # If s[start ~ end] is valid, increment dp[end + 1] by dp[start].
                dp[end + 1] += dp[start]
                dp[end + 1] %= mod
                    
        return dp[-1]