class Solution {
public:
    vector<vector<int>> getFactors(int n) {
        vector<vector<int>> ans;
        stack<vector<int>> stack;
        stack.push({n});
        while (!stack.empty()) {
            auto factors = stack.top();
            stack.pop();
            const int lastFactor = factors.back();
            factors.pop_back();
            for (int i = factors.empty() ? 2 : factors.back(); i <= lastFactor / i; ++i) {
                if (lastFactor % i == 0) {
                    vector<int> newFactors = factors;
                    newFactors.push_back(i);
                    newFactors.push_back(lastFactor / i);
                    stack.push(newFactors);
                    ans.push_back(newFactors);
                }
            }
        }
        return ans;
    }
};
