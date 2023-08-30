// This is the solution to Maximum Subarray, which is the maximum "normal sum"
// The algorithm is known as Kadane's algorithm

int maxSubArray(vector<int>& nums) {
    int currMax = nums[0];
    int maxSum = nums[0];

    for (int i = 1; i < nums.size(); i++) {
        int num = nums[i];
        currMax = max(num, currMax + num);
        maxSum = max(maxSum, currMax);
    }

    return maxSum;
}