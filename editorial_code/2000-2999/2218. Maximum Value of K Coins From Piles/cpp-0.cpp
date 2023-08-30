class Solution {
public:
    int maxValueOfCoins(vector<vector<int>>& piles, int k) {
        int n = piles.size();
        vector dp(n + 1, vector<int>(k + 1));
        for (int i = 1; i <= n; i++) {
            for (int coins = 0; coins <= k; coins++) {
                int currentSum = 0;
                for (int currentCoins = 0; currentCoins <= min((int)piles[i - 1].size(), coins); currentCoins++) {
                    if (currentCoins > 0) {
                        currentSum += piles[i - 1][currentCoins - 1];
                    }
                    dp[i][coins] = max(dp[i][coins], dp[i - 1][coins - currentCoins] + currentSum);
                }
            }
        }
        return dp[n][k];
    }
};