class Solution {
public:
    int arrayPairSum(vector<int>& nums) {
        // Sort the list in ascending order
        sort(nums.begin(), nums.end());
        // Initialize sum to zero
        int maxSum = 0;
        for (int i = 0; i < nums.size(); i += 2) {
            // Add every element at even positions (0-indexed)
            maxSum += nums[i];
        }
        return maxSum;
    }
};