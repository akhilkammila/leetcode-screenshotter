class Solution {
public:
    int findLongestChain(vector<vector<int>>& pairs) {
        // Sort pairs in ascending order based on the second element.
        sort(pairs.begin(), pairs.end(),
             [](const vector<int>& a, const vector<int>& b) { return a[1] < b[1]; });
        int curr = INT_MIN, ans = 0;

        for (const auto& pair : pairs) {
            if (pair[0] > curr) {
                ans++;
                curr = pair[1];
            }
        }
        return ans;
    }
};