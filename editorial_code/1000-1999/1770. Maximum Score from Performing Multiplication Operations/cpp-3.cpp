class Solution {
public:
    int maximumScore(vector<int>& nums, vector<int>& multipliers) {
        // For Right Pointer
        int n = int(nums.size());
        // Number of Operations
        int m = int(multipliers.size());
        vector dp(m + 1, vector<int>(m + 1, 0));
        
        for (int op = m - 1; op >= 0; op--) {
            for (int left = op; left >= 0; left--) {
                dp[op][left] = max(multipliers[op] * nums[left] + dp[op + 1][left + 1],
                                   multipliers[op] * nums[n - 1 - (op - left)] + dp[op + 1][left]);
            }
        }
        
        return dp[0][0];
    }
};