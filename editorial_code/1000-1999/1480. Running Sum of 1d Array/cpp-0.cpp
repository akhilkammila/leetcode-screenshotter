class Solution {
public:
    vector<int> runningSum(vector<int> &nums) {
        // Initialize result array with first element in nums.
        vector<int> result = {nums[0]};

        for (int i = 1; i < nums.size(); i++) {
            // Result at index `i` is sum of result at `i-1` and element at `i`.
            result.push_back(result.back() + nums[i]);
        }
        return result;
    }
};