class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        
        int[][] dp = new int[satisfaction.length + 1][satisfaction.length + 2];
        // Mark all the states initially as 0.
        for (int i = 0; i <= satisfaction.length; i++) {
            Arrays.fill(dp[i], 0);
        }
        
        for (int i = satisfaction.length - 1; i >= 0; i--) {
            for (int j = 1; j <= satisfaction.length; j++) {
                // Maximum of two choices:
                // 1. Cook the dish at `index` with the time taken as `time` and move on to the next dish with time as time + 1.
                // 2. Skip the current dish and move on to the next dish at the same time.
                dp[i][j] = Math.max(satisfaction[i] * j + dp[i + 1][j + 1], dp[i + 1][j]);
            }
        }
        
        return dp[0][1];
    }
}