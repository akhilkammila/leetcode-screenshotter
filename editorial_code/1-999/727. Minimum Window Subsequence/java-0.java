class Solution {
    public String minWindow(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        // declare the DP table
        int dp[][] = new int[n + 1][m + 1];
        // initialize dp with large values
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], 1000000000);
        }
        // the base case of DP
        dp[0][0] = 0;
        int end = 0, length = n + 1;
        for (int i = 1; i <= n; i++) {
            // the base case of DP
            dp[i][0] = 0;
            // DP transitions
            for (int j = 1; j <= m; j++) {
                // different transitions depending on whether or not s1[i - 1] == s2[j - 1]
                dp[i][j] = 1 + (s1.charAt(i - 1) == s2.charAt(j - 1) ? dp[i - 1][j - 1] : dp[i - 1][j]);
            }
            // update the answer
            if (dp[i][m] < length) {
                length = dp[i][m];
                end = i;
            }
        }
        // return the answer
        return length > n ? "" : s1.substring(end - length, end);
    }
}