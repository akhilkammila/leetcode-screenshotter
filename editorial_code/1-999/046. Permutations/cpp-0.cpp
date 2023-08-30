class Solution {
public:
    vector<vector<int>> permute(vector<int>& nums) {
        vector<vector<int>> ans;
        vector<int> curr = {};
        backtrack(curr, ans, nums);
        return ans;
    }
    
    void backtrack(vector<int>& curr, vector<vector<int>>& ans, vector<int>& nums) {
        if (curr.size() == nums.size()) {
            ans.push_back(curr);
            return;
        }
        
        for (int num: nums) {
            if (find(curr.begin(), curr.end(), num) == curr.end()) {
                curr.push_back(num);
                backtrack(curr, ans, nums);
                curr.pop_back();
            }
        }
    }
};