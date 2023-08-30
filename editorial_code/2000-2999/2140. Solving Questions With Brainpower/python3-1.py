class Solution:
    def mostPoints(self, questions: List[List[int]]) -> int:     
        n = len(questions)
        dp = [0] * n
        
        def dfs(i):
            if i >= n:
                return 0
            if dp[i]:
                return dp[i]
            points, skip = questions[i]

            # dp[i] = max(skip it, solve it)
            dp[i] = max(dfs(i + 1), points + dfs(i + skip + 1))
            return dp[i]
        
        return dfs(0)