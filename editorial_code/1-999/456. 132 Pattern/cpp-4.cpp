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
        int k = nums.size();
        for (size_t j = nums.size() - 1; j > 0; j--) {
            if (nums[j] <= min_array[j]) {
                continue;
            }
            auto it = lower_bound(nums.begin() + k, nums.end(), min_array[j] + 1);
            k = it - nums.begin();
            if (k < nums.size() and nums[k] < nums[j]) {
                return true;
            }
            nums[--k] = nums[j];
        }
        return false;
    }
};