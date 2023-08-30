class Solution {
public:
    vector<vector<int>> findSubsequences(vector<int>& nums) {
        int n = nums.size();
        set<vector<int>> result;
        for (int bitmask = 1; bitmask < (1 << n); bitmask++) {
            vector<int> sequence;
            for (int i = 0; i < n; i++) {
                // check the i-th bit of the bitmask
                if (((bitmask >> i) & 1) == 1) {
                    sequence.push_back(nums[i]);
                }
            }
            if (sequence.size() >= 2) {
                // check whether the sequence is increasing
                bool isIncreasing = true;
                for (int i = 0; i < sequence.size() - 1; i++) {
                    isIncreasing &= sequence[i] <= sequence[i + 1];
                }
                if (isIncreasing) {
                    result.insert(sequence);
                }
            }
        }
        return vector(result.begin(), result.end());
    }
};