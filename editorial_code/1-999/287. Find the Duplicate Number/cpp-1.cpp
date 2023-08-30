class Solution {
public:
    int findDuplicate(vector<int>& nums) {
        unordered_set<int> seen;
        for (auto &num : nums) {
            if (seen.count(num))
                return num;
            seen.insert(num);
        }
        return -1;
    }
};