class Solution {
public:
    int minBuildTime(vector<int>& blocks, int split) {        
        // Sort the blocks in descending order.
        int N = blocks.size();
        sort(blocks.begin(), blocks.end(), greater<int>());
        
        // Initialize the dp array. When all N blocks
        // done, we need 0 time.
        vector<int> dp(N + 1, 0);

        // The case when we have no workers.
        dp[0] = INT_MAX;
        
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
                int workHere = max(blocks[b], dp[w - 1]);
                int splitHere = split + dp[min(2 * w, N - b)];
                
                // Store the result in the dp array
                dp[w] = min(workHere, splitHere);
            }
        }
        
        // For building all the blocks, with initially 1 worker.
        return dp[1];
    }
};