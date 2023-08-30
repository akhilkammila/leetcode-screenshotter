class Solution {
public:
    bool find132pattern(vector<int>& nums) {
        if (nums.size() < 3) {
            return false;
        }
        vector<int> min_array(nums.size());
        min_array[0] = nums[0];

        for (size_t i = 1; i < nums.size(); i++) {
            min_array[i] = min(min_array[i - 1], nums[i]);
        }

        for (size_t j = nums.size() - 1, k = nums.size(); j > 0; j--) {
            if (nums[j] <= min_array[j]) {
                continue;
            }
            while (k < nums.size() and nums[k] <= min_array[j]) {
                k++;
            }
            if (k < nums.size() and nums[k] < nums[j]) {
                return true;
            }
            nums[--k] = nums[j];
        }
        return false;
    }
};