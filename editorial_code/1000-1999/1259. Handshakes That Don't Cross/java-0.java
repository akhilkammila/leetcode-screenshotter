class Solution {
    private static int m = 1000000007;

    public int numberOfWays(int numPeople) {
        int[] dp = new int[numPeople / 2 + 1];
        dp[0] = 1;
        for (int i = 1; i <= numPeople / 2; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += (long) dp[j] * dp[i - j - 1] % m;
                dp[i] %= m;
            }
        }
        return dp[numPeople / 2];
    }
}