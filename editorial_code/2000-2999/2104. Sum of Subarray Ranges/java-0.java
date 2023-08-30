class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        long answer = 0;
        
        for (int left = 0; left < n; ++left) {
            int minVal = nums[left], maxVal = nums[left];
            for (int right = left; right < n; ++right) {
                minVal = Math.min(minVal, nums[right]);
                maxVal = Math.max(maxVal, nums[right]);
                answer += maxVal - minVal;
            }
        }
        return answer;
    }
}