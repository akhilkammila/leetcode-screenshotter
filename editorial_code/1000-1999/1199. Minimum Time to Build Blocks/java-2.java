class Solution {
    public int minBuildTime(int[] blocks, int split) {        
        // Sort the blocks in descending order.
        int N = blocks.length;
        Arrays.sort(blocks);
        for (int i = 0; i < N / 2; i++) {
            int temp = blocks[i];
            blocks[i] = blocks[N - i - 1];
            blocks[N - i - 1] = temp;
        }
        
        // Initialize the dp array. When all N blocks
        // done, we need 0 time.
        int[] dp = new int[N + 1];
        for (int w = 0; w <= N; w++) {
            dp[w] = 0;
        }

        // The case when we have no workers.
        dp[0] = Integer.MAX_VALUE;
        
        // Fill the dp array in a bottom-up fashion.
        for (int b = N - 1; b >= 0; b--) {
            for (int w = N; w > 0; w--) {                
                // If we have more workers than blocks, 
                // Then we can build all the blocks.
                if (w >= N - b) {
                    dp[w] = blocks[b];
                    continue;
                }

                // Recurrence relation.
                int workHere = Math.max(blocks[b], dp[w - 1]);
                int splitHere = split + dp[Math.min(2 * w, N - b)];
                
                // Store the result in the dp array
                dp[w] = Math.min(workHere, splitHere);
            }
        }
        
        // For building all the blocks, with initially 1 worker.
        return dp[1];
    }
}