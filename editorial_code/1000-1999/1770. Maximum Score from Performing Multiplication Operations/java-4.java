class Solution {
    public int maximumScore(int[] nums, int[] multipliers) {
        // For Right Pointer
        int n = nums.length;
        // Number of Operations
        int m = multipliers.length;
        int[] dp = new int[m + 1];
        
        for (int op = m - 1; op >= 0; op--) {
            for (int left = 0; left <= op; left++) {
                dp[left] = Math.max(multipliers[op] * nums[left] + dp[left + 1],
                                   multipliers[op] * nums[n - 1 - (op - left)] + dp[left]);
            }
        }
        
        return dp[0];
    }
}