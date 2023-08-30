class Solution {
public:
    bool isMajorityElement(vector<int>& nums, int target) {
        int firstIndex = lower_bound(nums.begin(), nums.end(), target) - nums.begin();
        
        return firstIndex + nums.size() / 2 < nums.size() && nums[firstIndex + nums.size() / 2] == target;
    }
};