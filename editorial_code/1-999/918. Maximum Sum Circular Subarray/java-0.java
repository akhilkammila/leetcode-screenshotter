// This is the solution to Maximum Subarray, which is the maximum "normal sum"
// The algorithm is known as Kadane's algorithm
public int maxSubArray(int[] nums) {
    int currMax = nums[0];
    int maxSum = nums[0];

    for (int i = 1; i < nums.length; i++) {
        int num = nums[i];
        currMax = Math.max(num, currMax + num);
        maxSum = Math.max(maxSum, currMax);
    }
    
    return maxSum;
}