class Solution {
public:
    long long countSubarrays(vector<int>& nums) {
        long long currSubarray = 1;
        long long subarrayCount = 1;
        
        for (int i = 1; i < nums.size(); i++) {
            // If the current element is greater, increase the subarrays.
            if (nums[i] > nums[i - 1]) {
                currSubarray++;
            } else {
                // Otherwise, reset the subarray size to 1.
                currSubarray = 1;
            }
            // Add the number of subarrays to the total count.
            subarrayCount += currSubarray;
        }
        
        return subarrayCount;
    }
};