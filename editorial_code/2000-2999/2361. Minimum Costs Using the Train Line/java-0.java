class Solution {
    long solve(int i, int lane, long[][] dp, int[] regular, int[] express, int expressCost) {
        // If all stops are covered, return 0.
        if (i < 0) {
            return 0;
        }
        
        if (dp[i][lane] != -1) {
            return dp[i][lane];
        }
        
        // Use the regular lane; no extra cost to switch lanes if required.
        long regularLane = regular[i] + solve(i - 1, 1, dp, regular, express, expressCost);
        // Use express lane; add expressCost if the previously regular lane was used.
        long expressLane = (lane == 1 ? expressCost : 0) + express[i] 
                                                    + solve(i - 1, 0, dp, regular, express, expressCost);

        return dp[i][lane] = Math.min(regularLane, expressLane);
    }
    
    public long[] minimumCosts(int[] regular, int[] express, int expressCost) {
        long[][] dp = new long[regular.length][2];
        for (int i = 0; i < regular.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        
        solve(regular.length - 1, 1, dp, regular, express, expressCost);
        
        long[] ans = new long[regular.length];
        // Store cost for each stop.
        for (int i = 0 ; i < regular.length; i++) {
            ans[i] = dp[i][1];
        }
        
        return ans;
    }
}