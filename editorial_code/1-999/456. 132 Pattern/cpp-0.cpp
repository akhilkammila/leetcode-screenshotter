class Solution {
public:
    bool find132pattern(vector<int>& nums) {
        if (nums.size() < 3) {
            return false;
        }
        for (size_t i = 0; i < nums.size() - 2; i++) {
            for (size_t j = i + 1; j < nums.size() - 1; j++) {
                for (size_t k = j + 1; k < nums.size(); k++) {
                    if (nums[k] > nums[i] and nums[j] > nums[k]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
};