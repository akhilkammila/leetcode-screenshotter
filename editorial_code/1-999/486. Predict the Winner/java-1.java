class Solution {
    int[][] memo;
    
    private int maxDiff(int[] nums, int left, int right, int n) {
        if (memo[left][right] != -1) {
            return memo[left][right];
        }
        if (left == right) {
            return nums[left];
        }
        
        int scoreByLeft = nums[left] - maxDiff(nums, left + 1, right, n);
        int scoreByRight = nums[right] - maxDiff(nums, left, right - 1, n);
        memo[left][right] = Math.max(scoreByLeft, scoreByRight);
        
        return memo[left][right];
    }
    
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        memo = new int[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(memo[i], -1);
        }
        
        return maxDiff(nums, 0, n - 1, n) >= 0;
    }
}