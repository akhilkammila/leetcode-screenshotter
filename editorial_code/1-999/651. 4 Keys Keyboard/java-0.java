class Solution {
    public int maxA(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = i;
        }
        for (int i = 0; i <= n - 3; i++) {
            for (int j = i + 3; j <= Math.min(n, i + 6); j++) {
                dp[j] = Math.max(dp[j], (j - i - 1) * dp[i]);
            }
        }
        return dp[n];
    }
}