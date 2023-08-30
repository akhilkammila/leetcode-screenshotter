class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        int[] dp = Arrays.copyOf(nums, n);
        
        for (int diff = 1; diff < n; ++diff) {
            for (int left = 0; left < n - diff; ++left) {
                int right = left + diff;
                dp[left] = Math.max(nums[left] - dp[left + 1], nums[right] - dp[left]);
            }
        }
        
        return dp[0] >= 0;
    }
}   