class Solution {
    void backtracking(vector<int>& factors, vector<vector<int>>& ans) {
        // Got a solution,
        if (factors.size() > 1) {
            ans.push_back(factors);
        }
        const int lastFactor = factors.back();
        factors.pop_back();
        for (int i = factors.empty() ? 2 : factors.back(); i <= lastFactor / i; ++i) {
            if (lastFactor % i == 0) {
                // Add i and lastFactor / i.
                factors.push_back(i);
                factors.push_back(lastFactor / i);
                backtracking(factors, ans);
                // Remove the last 2 elements in factors to restore it after the recursion returns
                factors.pop_back();
                factors.pop_back();
            }
        }
        // Add lastFactor back to factors to restore it.
        factors.push_back(lastFactor);
    }

public:
    vector<vector<int>> getFactors(int n) {
        vector<int> factors = {n};
        vector<vector<int>> ans;
        backtracking(factors, ans);
        return ans;
    }
};