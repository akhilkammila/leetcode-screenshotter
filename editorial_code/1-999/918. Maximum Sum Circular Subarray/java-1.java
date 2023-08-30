class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        final int n = nums.length;
        final int[] rightMax = new int[n];
        rightMax[n - 1] = nums[n - 1];
        int suffixSum = nums[n - 1];

        for (int i = n - 2; i >= 0; --i) {
            suffixSum += nums[i];
            rightMax[i] = Math.max(rightMax[i + 1], suffixSum);
        }

        int maxSum = nums[0];
        int specialSum = nums[0];
        int curMax = 0;
        for (int i = 0, prefixSum = 0; i < n; ++i) {
            // This is Kadane's algorithm.
            curMax = Math.max(curMax, 0) + nums[i];
            maxSum = Math.max(maxSum, curMax);

            prefixSum += nums[i];
            if (i + 1 < n) {
                specialSum = Math.max(specialSum, prefixSum + rightMax[i + 1]);
            }
        }

        return Math.max(maxSum, specialSum);  
    }
}