class Solution {
    public:
    int helper(vector<int>& nums, vector<int>& multipliers, int left, int right, int op) {
        if (op == int(multipliers.size())) {
            return 0;
        }
        
        int l = nums[left] * multipliers[op] + helper(nums, multipliers, left + 1, right, op + 1);
        int r = nums[right] * multipliers[op] + helper(nums, multipliers, left, right - 1, op + 1);
        
        return max(l, r);
    }

    int maximumScore(vector<int>& nums, vector<int>& multipliers) {
        return helper(nums, multipliers, 0, int(nums.size()) - 1, 0);
    }
};