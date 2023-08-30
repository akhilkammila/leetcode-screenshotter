class Solution {
    public int minBuildTime(int[] blocks, int split) {
        // Sort the blocks in descending order.
        int N = blocks.length;
        Arrays.sort(blocks);
        for (int i = 0; i < N / 2; i++) {
            int tmp = blocks[i];
            blocks[i] = blocks[N - i - 1];
            blocks[N - i - 1] = tmp;
        }
        
        // Initialize the dp array.
        int[][] dp = new int[N + 1][N + 1];
        
        // Base case 1: If there are no workers, then we can't build any block.
        for (int b = 0; b < N; b++) {
            dp[b][0] = Integer.MAX_VALUE;
        }
        
        // Base case 2: If there are no blocks, then we don't need any time.
        for (int w = 0; w <= N; w++) {
            dp[N][w] = 0;
        }
        
        // Fill the dp array in a bottom-up fashion.
        for (int b = N - 1; b >= 0; b--) {
            for (int w = N; w >= 1; w--) {                
                // Base case 3: If we have more workers than blocks, 
                //Then we can build all the blocks.
                if (w >= N - b) {
                    dp[b][w] = blocks[b];
                    continue;
                }

                // Recurrence relation.
                int workHere = Math.max(blocks[b], dp[b + 1][w - 1]);
                int splitHere = split + dp[b][Math.min(2 * w, N - b)];
                
                // Store the result in the dp array
                dp[b][w] = Math.min(workHere, splitHere);
            }
        }
        
        // For building all the blocks, with 
        // initially 1 worker.
        return dp[0][1];
    }
};