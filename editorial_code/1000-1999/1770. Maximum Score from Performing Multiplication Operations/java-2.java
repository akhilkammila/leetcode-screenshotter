class Solution {
    int dp(Integer[][] memo, int[] nums, int[] multipliers, int op, int left) {
        // For Right Pointer
        int n = nums.length;
        if (op == multipliers.length) {
            return 0;
        }

        // If already computed, return
        if (memo[op][left] != null) {
            return memo[op][left];
        }

        int l = nums[left] * multipliers[op] + dp(memo, nums, multipliers, op + 1, left + 1);
        int r = nums[(n - 1) - (op - left)] * multipliers[op] + dp(memo, nums, multipliers, op + 1, left);

        return memo[op][left] = Math.max(l, r);
    }

    public int maximumScore(int[] nums, int[] multipliers) {
        Integer[][] memo = new Integer[multipliers.length + 1][multipliers.length + 1];
        // Zero operation done in the beginning
        return dp(memo, nums, multipliers, 0, 0);
    }
}