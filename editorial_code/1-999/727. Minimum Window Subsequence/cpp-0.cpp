class Solution {
public:
    string minWindow(string s1, string s2) {
        int n = s1.size(), m = s2.size();
        // declare the DP table and initialize it with large values
        vector dp(n + 1, vector<int>(m + 1, 1000000000));
        // the base case of DP
        dp[0][0] = 0;
        int end = 0, length = n + 1;
        for (int i = 1; i <= n; i++) {
            // the base of DP
            dp[i][0] = 0;
            // DP transitions
            for (int j = 1; j <= m; j++) {
                // different transitions depending on whether or not s1[i - 1] == s2[j - 1]
                dp[i][j] = 1 + (s1[i - 1] == s2[j - 1] ? dp[i - 1][j - 1] : dp[i - 1][j]);
            }
            // update the answer
            if (dp[i][m] < length) {
                length = dp[i][m];
                end = i;
            }
        }
        // return the answer
        return length > n ? "" : s1.substr(end - length, length);
    }
};