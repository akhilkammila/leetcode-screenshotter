class Solution {
    public int strangePrinter(String s) {
        int n = s.length();
        int dp[][] = new int[n][n];
        for (int length = 1; length <= n; length++) {
            for (int left = 0; left <= n - length; left++) {
                int right = left + length - 1;
                int j = -1;
                dp[left][right] = n;
                for (int i = left; i < right; i++) {
                    if (s.charAt(i) != s.charAt(right) && j == -1) {
                        j = i;
                    }
                    if (j != -1) {
                        dp[left][right] = Math.min(dp[left][right], 1 + dp[j][i] + dp[i + 1][right]);
                    }
                }
                
                if (j == -1) {
                    dp[left][right] = 0;
                }
                
            }
        }

        return dp[0][n - 1] + 1;
    }
}