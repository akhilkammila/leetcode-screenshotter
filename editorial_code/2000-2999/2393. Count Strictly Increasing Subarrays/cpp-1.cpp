class Solution {
public:
    long long countSubarrays(vector<int>& nums) {
        // Variable to store the total number of subarrays.
        long subarrayCount = 0;
        
        for (int i = 0; i < nums.size(); i++) {
            // Length of the current subarray.
            long currSubarray = 1;
            
            while (i + 1 < nums.size() && nums[i] < nums[i + 1]) {
                currSubarray++;
                i++;
            }
            
            // Add the total number of different subarrays possible from this length.
            subarrayCount += (currSubarray * (currSubarray + 1)) / 2;
        }
        
        return subarrayCount;
    }
};