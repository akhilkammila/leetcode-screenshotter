class Solution {
public:
    int search(vector<int>& nums, int target) {
        // Find the insertion position `idx`.
        int idx = upper_bound(nums.begin(), nums.end(), target) - nums.begin();

        if (idx > 0 && nums[idx - 1] == target) {
            return idx - 1;
        } else {
            return -1;
        }    
    }
};