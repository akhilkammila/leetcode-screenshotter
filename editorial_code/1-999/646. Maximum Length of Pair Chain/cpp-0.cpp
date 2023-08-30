class Solution {
public:
    int longestPairChain(int i, vector<vector<int>>& pairs, int& n, vector<int>& memo) {
        if (memo[i] != 0) {
            return memo[i];
        }
        memo[i] = 1;
        for (int j = i + 1; j < n; j++) {
            if (pairs[i][1] < pairs[j][0]) {
                memo[i] = max(memo[i], 1 + longestPairChain(j, pairs, n, memo));
            }
        }
        return memo[i];
    }

    int findLongestChain(vector<vector<int>>& pairs) {
        int n = pairs.size();
        sort(pairs.begin(), pairs.end());
        vector<int> memo(n);

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = max(ans, longestPairChain(i, pairs, n, memo));
        }
        return ans;
    }
};