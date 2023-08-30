class Solution {
    private int maxDiff(int[] nums, int left, int right, int n) {
        if (left == right) {
            return nums[left];
        }
        
        int scoreByLeft = nums[left] - maxDiff(nums, left + 1, right, n);
        int scoreByRight = nums[right] - maxDiff(nums, left, right - 1, n);
        
        return Math.max(scoreByLeft, scoreByRight);
    }
    
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        
        return maxDiff(nums, 0, n - 1, n) >= 0;
    }
}