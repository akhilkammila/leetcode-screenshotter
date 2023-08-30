class Solution {
public:
    int lcs(string& s1, string& s2, int m, int n, vector<vector<int>>& memo) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (memo[m][n] != -1) {
            return memo[m][n];
        }
        if (s1[m - 1] == s2[n - 1]) {
            return memo[m][n] = 1 + lcs(s1, s2, m - 1, n - 1, memo);
        }
        return memo[m][n] = max(lcs(s1, s2, m - 1, n, memo), lcs(s1, s2, m, n - 1, memo));
    }

    int minInsertions(string s) {
        int n = s.length();
        string sReverse = s;
        reverse(sReverse.begin(), sReverse.end());
        vector<vector<int>> memo(n + 1, vector<int>(n + 1));

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                memo[i][j] = -1;
            }
        }

        return n - lcs(s, sReverse, n, n, memo);
    }
};