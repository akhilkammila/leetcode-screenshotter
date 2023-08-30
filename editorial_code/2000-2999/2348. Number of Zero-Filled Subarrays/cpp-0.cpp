class Solution {
public:
    long long zeroFilledSubarray(vector<int>& nums) {
        long long ans = 0, numSubarray = 0;
        
        // Iterate over nums, if num = 0, it has 1 more zero-filled subarray
        // than the previous one, otherwise, it has 0 zero-filled subarray.
        for (auto num : nums) {
            if (num == 0)
                numSubarray++;
            else
                numSubarray = 0;
            ans += numSubarray;
        }
        
        return ans;
    }
};