class Solution {
public:
    int dp(vector<vector<int>>& memo, vector<int>& nums, vector<int>& multipliers, int op, int left) {
        // For Right Pointer
        int n = int(nums.size());
        if (op == int(multipliers.size())) {
            return 0;
        }

        // If already computed, return
        if (memo[op][left] != INT_MIN) {
            return memo[op][left];
        }

        int l = nums[left] * multipliers[op] + dp(memo, nums, multipliers, op + 1, left + 1);
        int r = nums[(n - 1) - (op - left)] * multipliers[op] + dp(memo, nums, multipliers, op + 1, left);

        return memo[op][left] = max(l, r);
    }

    int maximumScore(vector<int>& nums, vector<int>& multipliers) {
        vector memo(multipliers.size() + 1, vector<int>(multipliers.size() + 1, INT_MIN));
        // Zero operation done in the beginning
        return dp(memo, nums, multipliers, 0, 0);
    }
};