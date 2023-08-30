class Solution {
    public int minTaps(int n, int[] ranges) {
        // Define an infinite value
        final int INF = (int) 1e9;
        
        // Create an array to store the minimum number of taps needed for each position
        int[] dp = new int[n + 1];
        Arrays.fill(dp, INF);
        
        // Initialize the starting position of the garden
        dp[0] = 0;
        
        for (int i = 0; i <= n; i++) {
            // Calculate the leftmost position reachable by the current tap
            int tapStart = Math.max(0, i - ranges[i]);
            // Calculate the rightmost position reachable by the current tap
            int tapEnd = Math.min(n, i + ranges[i]);
            
            for (int j = tapStart; j <= tapEnd; j++) {
                // Update with the minimum number of taps
                dp[tapEnd] = Math.min(dp[tapEnd], dp[j] + 1);
            }
        }
        
        // Check if the garden can be watered completely
        if (dp[n] == INF) {
            // Garden cannot be watered
            return -1;
        }
        
        // Return the minimum number of taps needed to water the entire garden
        return dp[n];
    }
}