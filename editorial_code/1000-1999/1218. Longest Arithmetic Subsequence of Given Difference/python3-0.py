class Solution:
    def longestSubsequence(self, arr: List[int], difference: int) -> int:
        dp = {}
        answer = 1
        for a in arr:
            before_a = dp.get(a - difference, 0)
            dp[a] = before_a + 1
            answer = max(answer, dp[a])
            
        return answer