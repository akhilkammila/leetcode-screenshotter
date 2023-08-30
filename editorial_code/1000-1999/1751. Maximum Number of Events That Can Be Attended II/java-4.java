class Solution {
    int[][] dp;
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        int n = events.length;
        dp = new int[k + 1][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return dfs(0, 0, -1, events, k);
    }
    
    private int dfs(int curIndex, int count, int prevEndingTime, int[][] events, int k) {
        if (curIndex == events.length || count == k) {
            return 0;
        }
        
        if (prevEndingTime >= events[curIndex][0]) {
            return dfs(curIndex + 1, count, prevEndingTime, events, k);
        }
        
        if (dp[count][curIndex] != -1) {
            return dp[count][curIndex];
        }
        
        int ans = Math.max(dfs(curIndex + 1, count, prevEndingTime, events, k),
                           dfs(curIndex + 1, count + 1, events[curIndex][1], events, k) + events[curIndex][2]);
        dp[count][curIndex] = ans;
        return ans;
    }
}