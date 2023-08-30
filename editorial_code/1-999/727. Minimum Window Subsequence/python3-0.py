class Solution:
    def minWindow(self, s1: str, s2: str) -> str:
        n = len(s1)
        m = len(s2)
        # declare the DP table and initialize it with large values
        dp = [[1000000000] * (m + 1) for i in range(n + 1)]
        # the base case of DP
        dp[0][0] = 0
        end = 0
        length = n + 1
        for i in range(1, n + 1):
            # the base case of DP
            dp[i][0] = 0
            # DP transitions
            for j in range(1, m + 1):
                # different transitions depending on whether s1[i-1] == s2[j-1]
                dp[i][j] = 1 + (dp[i - 1][j - 1] if s1[i - 1] == s2[j - 1]
                                else dp[i - 1][j])
            # update the answer
            if dp[i][m] < length:
                length = dp[i][m]
                end = i
        # return the answer
        return "" if length > n else s1[end - length:end]