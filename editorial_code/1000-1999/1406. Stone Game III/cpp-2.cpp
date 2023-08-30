class Solution {
public:
    string stoneGameIII(vector<int>& stoneValue) {
        int n = stoneValue.size();
        int notComputed = 1000000000;
        vector<int> dp(n + 1, notComputed);
        
        function<int(int)> f = [&](int i) -> int {
            if (i == n) {
                return 0;
            }
            if (dp[i] != notComputed) {
                return dp[i];
            }
            dp[i] = stoneValue[i] - f(i + 1);
            if (i + 2 <= n) {
                dp[i] = max(dp[i], stoneValue[i] + stoneValue[i + 1] - f(i + 2));
            }
            if (i + 3 <= n) {
                dp[i] = max(dp[i], stoneValue[i] + stoneValue[i + 1]
                    + stoneValue[i + 2] - f(i + 3));
            }
            return dp[i];
        };

        int dif = f(0);
        if (dif > 0) {
            return "Alice";
        }
        if (dif < 0) {
            return "Bob";
        }
        return "Tie";
    }
};