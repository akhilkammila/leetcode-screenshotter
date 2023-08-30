class Solution {
    private int lcs(String s1, String s2, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    // One of the two strings is empty.
                    dp[i][j] = 0;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }

    public int minInsertions(String s) {
        int n = s.length();
        String sReverse = new StringBuilder(s).reverse().toString();

        return n - lcs(s, sReverse, n, n);
    }
}