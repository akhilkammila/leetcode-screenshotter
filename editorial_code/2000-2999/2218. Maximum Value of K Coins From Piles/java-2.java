class Solution {
    int dp[][];
    private int f(List<List<Integer>> piles, int i, int coins) {
        if (i == 0) {
            return 0;
        }
        if (dp[i][coins] != -1) {
            return dp[i][coins];
        }
        int currentSum = 0;
        for (int currentCoins = 0; currentCoins <= Math.min(piles.get(i - 1).size(), coins); currentCoins++) {
            if (currentCoins > 0) {
                currentSum += piles.get(i - 1).get(currentCoins - 1);
            }
            dp[i][coins] = Math.max(dp[i][coins], f(piles, i - 1, coins - currentCoins) + currentSum);
        }
        return dp[i][coins];
    }
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int n = piles.size();
        dp = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            for (int coins = 0; coins <= k; coins++) {
                dp[i][coins] = -1;
            }
        }
        return f(piles, n, k);
    }
}