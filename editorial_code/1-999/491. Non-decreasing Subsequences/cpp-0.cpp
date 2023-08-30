class Solution {
public:
    vector<vector<int>> findSubsequences(vector<int>& nums) {
        set<vector<int>> result;
        vector<int> sequence;
        function<void(int)> backtrack;
        backtrack = [&nums, &sequence, &result, &backtrack](int index) -> void {
            // if we have checked all elements
            if (index == nums.size()) {
                if (sequence.size() >= 2) {
                    result.insert(sequence);
                }
                return;
            }
            // if the sequence remains increasing after appending nums[index]
            if (sequence.empty() || sequence.back() <= nums[index]) {
                // append nums[index] to the sequence
                sequence.push_back(nums[index]);
                // call recursively
                backtrack(index + 1);
                // delete nums[index] from the end of the sequence
                sequence.pop_back();
            }
            // call recursively not appending an element
            backtrack(index + 1);
        };
        backtrack(0);
        return vector(result.begin(), result.end());
    }
};