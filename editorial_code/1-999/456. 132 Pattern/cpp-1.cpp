class Solution {
public:
    bool find132pattern(vector<int>& nums) {
        int min_i = INT_MAX;
        for (size_t j = 0; j < nums.size() - 1; j++) {
            min_i = min(min_i, nums[j]);
            for (size_t k = j + 1; k < nums.size(); k++) {
                if (nums[k] < nums[j] and min_i < nums[k]) {
                    return true;
                }
            }
        }
        return false;
    }
};