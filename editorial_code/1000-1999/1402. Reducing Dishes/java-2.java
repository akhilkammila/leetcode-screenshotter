class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        
        // Array to keep the result for the previous iteration.
        int[] prev = new int[satisfaction.length + 2];
        Arrays.fill(prev, 0);
        
        for (int index = satisfaction.length - 1; index >= 0; index--) {
            // Array to keep the result for the current iteration.
            int[] dp = new int[satisfaction.length + 2];
            
            for (int time = 1; time <= satisfaction.length; time++) {
                // Maximum of two choices:
                // 1. Cook the dish at `index` with the time taken as `time` and move on to the next dish with time as time + 1.
                // 2. Skip the current dish and move on to the next dish at the same time.
                dp[time] = Math.max(satisfaction[index] * time + prev[time + 1], prev[time]);
            }
            // Assign the current iteration result to prev to be used in the next iteration.
            prev = dp;
        }
        // dp and prev have the same value here, but dp is not defined at this scope.
        return prev[1];
    }
}