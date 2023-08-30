class Solution {
public:
    int missingElement(vector<int>& nums, int k) {
        int n = nums.size();
        
        for (int i = 1; i < n; ++i) {
            int missedInGap = nums[i] - nums[i - 1] - 1;
            if (missedInGap >= k) {
                return nums[i - 1] + k;
            }
            k -= missedInGap;
        }
        
        return nums[n - 1] + k;
    }
};