class Solution:
    def maxValue(self, events: List[List[int]], k: int) -> int:
        events.sort()
        n = len(events)
        dp = [[-1] * n for _ in range(k + 1)]
        
        def dfs(cur_index, count, prev_ending_time):
            if cur_index == n or count == k:
                return 0
            if events[cur_index][0] <= prev_ending_time:            
                return dfs(cur_index + 1, count, prev_ending_time)
            
            if dp[count][cur_index] != -1:
                return dp[count][cur_index]
            
            ans = max(dfs(cur_index + 1, count, prev_ending_time), dfs(cur_index + 1, count + 1, events[cur_index][1]) + events[cur_index][2])
            dp[count][cur_index] = ans
            return ans

        return dfs(0, 0, -1)