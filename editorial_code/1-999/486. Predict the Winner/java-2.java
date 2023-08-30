class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; ++i) {
            dp[i][i] = nums[i];
        }
        
        for (int diff = 1; diff < n; ++diff) {
            for (int left = 0; left < n - diff; ++left) {
                int right = left + diff;
                dp[left][right] = Math.max(nums[left] - dp[left + 1][right],
                                          nums[right] - dp[left][right - 1]);
            }
        }
        
        return dp[0][n - 1] >= 0;
    }
}