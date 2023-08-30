class Solution {
    public int minBuildTime(int[] blocks, int split) {       
        // Sort the blocks in descending order
        Arrays.sort(blocks);
        for (int i = 0; i < blocks.length / 2; i++) {
            int temp = blocks[i];
            blocks[i] = blocks[blocks.length - i - 1];
            blocks[blocks.length - i - 1] = temp;
        }
        
        // dp[i][j] represents the minimum time taken to build blocks[i~n-1] block using j workers
        int[][] dp = new int[blocks.length][blocks.length + 1];

        // Initialize the dp array with -1
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        // Call for the block from index 0 with 1 worker
        return solve(blocks, split, 0, 1, dp);
    }

    private int solve(int[] blocks, int split, int b, int w, int[][] dp) {
        // Base cases
        if (b == blocks.length) {
            return 0;
        }
        if (w == 0) {
            return Integer.MAX_VALUE;
        }
        if (w >= blocks.length - b) {
            return blocks[b];
        }

        // If the sub-problem is already solved, return the result
        if (dp[b][w] != -1) {
            return dp[b][w];
        }

        // Two Choices
        int workHere = Math.max(blocks[b], solve(blocks, split, b + 1, w - 1, dp));
        int splitHere = split + solve(blocks, split, b, Math.min(2 * w, blocks.length - b), dp);

        // Store the result in the dp array
        dp[b][w] = Math.min(workHere, splitHere);
        return dp[b][w];
    }
}