class Solution {
public:
    int minBuildTime(vector<int>& blocks, int split) {        
        // Sort the blocks in descending order.
        int N = blocks.size();
        sort(blocks.begin(), blocks.end(), greater<int>());
        
        // Initialize the dp array.
        vector<vector<int>> dp(N + 1, vector<int>(N + 1, 0));
        
        // Base case 1: If there are no workers, then we can't build any block.
        for (int b = 0; b < N; b++) {
            dp[b][0] = INT_MAX;
        }
        
        // Base case 2: If there are no blocks, then we don't need any time.
        for (int w = 0; w <= N; w++) {
            dp[N][w] = 0;
        }
        
        // Fill the dp array in a bottom-up fashion.
        for (int b = N - 1; b >= 0; b--) {
            for (int w = N; w >= 1; w--) {                
                // Base case 3: If we have more workers than blocks, 
                // Then we can build all the blocks.
                if (w >= N - b) {
                    dp[b][w] = blocks[b];
                    continue;
                }

                // Recurrence relation.
                int workHere = max(blocks[b], dp[b + 1][w - 1]);
                int splitHere = split + dp[b][min(2 * w, N - b)];
                
                // Store the result in the dp array
                dp[b][w] = min(workHere, splitHere);
            }
        }
        
        // For building all the blocks, with 
        // initially 1 worker.
        return dp[0][1];
    }
};