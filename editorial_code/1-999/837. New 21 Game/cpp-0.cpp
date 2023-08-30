class Solution {
public:
    double new21Game(int n, int k, int maxPts) {
        vector<double> dp(n + 1);
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= maxPts; j++) {
                if (i - j >= 0 && i - j < k) {
                    dp[i] += dp[i - j] / maxPts;
                }
            }
        }
        return accumulate(dp.begin() + k, dp.end(), 0.0);
    }
};