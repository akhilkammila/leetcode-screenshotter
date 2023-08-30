class Solution {
    public int partitionDisjoint(int[] nums) {
        int currMax = nums[0];
        int possibleMax = nums[0];
        int length = 1;
        
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] < currMax) {
                length = i + 1;
                currMax = possibleMax;
            } else {
                possibleMax = Math.max(possibleMax, nums[i]);
            }
        }
        
        return length;
    }
}