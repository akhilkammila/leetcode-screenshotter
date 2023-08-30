class Solution {
    private static int m = 1000000007;
    int[] dp;

    public int numberOfWays(int numPeople) {
        dp = new int[numPeople / 2 + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        return calculateDP(numPeople / 2);
    }

    private int calculateDP(int i) {
        if (dp[i] != -1) {
            return dp[i];
        }
        dp[i] = 0;
        for (int j = 0; j < i; j++) {
            dp[i] += (long) calculateDP(j) * calculateDP(i - j - 1) % m;
            dp[i] %= m;
        }
        return dp[i];
    }
}