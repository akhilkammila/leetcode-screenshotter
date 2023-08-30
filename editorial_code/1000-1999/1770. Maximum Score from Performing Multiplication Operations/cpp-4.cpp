class Solution {
public:
    int maximumScore(vector<int>& nums, vector<int>& multipliers) {
        // For Right Pointer
        int n = int(nums.size());
        // Number of Operations
        int m = int(multipliers.size());
        vector<int> dp(m + 1, 0);
        
        for (int op = m - 1; op >= 0; op--) {
            for (int left = 0; left <= op; left++) {
                dp[left] = max(multipliers[op] * nums[left] + dp[left + 1],
                               multipliers[op] * nums[n - 1 - (op - left)] + dp[left]);
            }
        }
        
        return dp[0];
    }
};