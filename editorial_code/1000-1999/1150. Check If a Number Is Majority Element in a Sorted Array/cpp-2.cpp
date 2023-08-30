class Solution {
public:
    bool isMajorityElement(vector<int>& nums, int target) {
        int firstIndex = lower_bound(nums.begin(), nums.end(), target) - nums.begin();
        int nextToLastIndex = upper_bound(nums.begin(), nums.end(), target) - nums.begin();
        
        return nextToLastIndex - firstIndex > nums.size() / 2;
    }
};