class Solution {
public:
    int maxValueOfCoins(vector<vector<int>>& piles, int k) {
        int n = piles.size();
        vector dp(n + 1, vector<int>(k + 1, -1));
        
        function<int(int, int)> f = [&](int i, int coins) {
            if (i == 0) {
                return 0;
            }
            if (dp[i][coins] != -1) {
                return dp[i][coins];
            }
            int currentSum = 0;
            for (int currentCoins = 0; currentCoins <= min((int)piles[i - 1].size(), coins); currentCoins++) {
                if (currentCoins > 0) {
                    currentSum += piles[i - 1][currentCoins - 1];
                }
                dp[i][coins] = max(dp[i][coins], f(i - 1, coins - currentCoins) + currentSum);
            }
            return dp[i][coins];
        };
        
        return f(n, k);
    }
};