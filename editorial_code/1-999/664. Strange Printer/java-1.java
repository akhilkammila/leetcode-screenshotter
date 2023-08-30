class Solution {
    int dp[][];

    private int solve(String s, int n, int left, int right) {
        if (dp[left][right] != -1) {
            return dp[left][right];
        }

        dp[left][right] = n;
        int j = -1;
        for (int i = left; i < right; i++) {
            if (s.charAt(i) != s.charAt(right) && j == -1) {
                j = i;
            }
            
            if (j != -1) {
                dp[left][right] = Math.min(dp[left][right], 1 + solve(s, n, j, i) + solve(s, n, i + 1, right));
            }
        }
        
        if (j == -1) {
            dp[left][right] = 0;
        }
        
        return dp[left][right];
    }

    public int strangePrinter(String s) {
        int n = s.length();
        dp = new int[n][n];
        for (int left = 0; left < n; left++) {
            for (int right = 0; right < n; right++) {
                dp[left][right] = -1;
            }
        }

        return solve(s, n, 0, n - 1) + 1;
    }
}