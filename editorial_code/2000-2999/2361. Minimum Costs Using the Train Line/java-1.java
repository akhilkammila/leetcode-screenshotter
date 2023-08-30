class Solution {
    public long[] minimumCosts(int[] regular, int[] express, int expressCost) {
        long[] ans = new long[regular.length];
        
        long[][] dp = new long[regular.length + 1][2];
        dp[0][1] = 0;
        // Need to spend expressCost, as we start from the regular lane initially.
        dp[0][0] = expressCost;
        
        for (int i = 1; i < regular.length + 1; i++) {
            // Use the regular lane; no extra cost to switch to the express lane.
            dp[i][1] = regular[i - 1] + Math.min(dp[i - 1][1], dp[i - 1][0]);
            // Use express lane; add extra cost if the previously regular lane was used.
            dp[i][0] = express[i - 1] + Math.min(expressCost + dp[i - 1][1], dp[i - 1][0]);
            
            ans[i - 1] = Math.min(dp[i][0], dp[i][1]);
        }
        return ans; 
    }
}