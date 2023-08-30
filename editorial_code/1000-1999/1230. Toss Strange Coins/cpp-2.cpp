class Solution {
public:
    double probabilityOfHeads(vector<double>& prob, int target) {
        int n = prob.size();
        vector<double> dp(target + 1);
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = target; j >= 1; j--) {
                dp[j] = dp[j - 1] * prob[i - 1] + dp[j] * (1 - prob[i - 1]);
            }
            dp[0] = dp[0] * (1 - prob[i - 1]);
        }

        return dp[target];
    }
};