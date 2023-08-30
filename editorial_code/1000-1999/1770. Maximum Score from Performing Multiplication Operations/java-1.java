class Solution {
    int helper(int[] nums, int[] multipliers, int left, int right, int op) {

        if (op == multipliers.length) {
            return 0;
        }

        int l = nums[left] * multipliers[op] + helper(nums, multipliers, left + 1, right, op + 1);
        int r = nums[right] * multipliers[op] + helper(nums, multipliers, left, right - 1, op + 1);

        return Math.max(l, r);
    }

    public int maximumScore(int[] nums, int[] multipliers) {
        return helper(nums, multipliers, 0, nums.length - 1, 0);
    }
}