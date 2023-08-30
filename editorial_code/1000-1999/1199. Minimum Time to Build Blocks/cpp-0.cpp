class Solution {
public:
    int minBuildTime(vector<int>& blocks, int split) {        
        // Sort the blocks in descending order
        sort(blocks.begin(), blocks.end(), greater<int>());
        
        // dp[i][j] represents the minimum time taken to build blocks[i~n-1] block using j workers
        vector<vector<int>> dp(blocks.size(), vector<int>(blocks.size() + 1, -1));
        
        // Call for the block from index 0 with 1 worker
        return solve(blocks, split, 0, 1, dp);
    }
    
    int solve(vector<int>& blocks, int split, int b, int w, vector<vector<int>>& dp) {        
        // Base cases
        if (b == blocks.size()) {
            return 0;
        }
        if (w == 0) {
            return INT_MAX;
        }
        if (w >= blocks.size() - b) {
            return blocks[b];
        }
        
        // If the sub-problem is already solved, return the result
        if (dp[b][w] != -1) {
            return dp[b][w];
        }
        
        // Two Choices
        int workHere = max(blocks[b], solve(blocks, split, b + 1, w - 1, dp));
        int splitHere = split + solve(blocks, split, b, min(2 * w, (int)blocks.size() - b), dp);
        
        // Store the result in the dp array
        dp[b][w] = min(workHere, splitHere);
        return dp[b][w];
    }
};