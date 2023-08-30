class Solution {
public:
    int strangePrinter(string s) {
        int n = s.size();
        vector dp(n, vector<int>(n, -1));

        function<int(int, int)> solve = [&](int left, int right) -> int {
            if (dp[left][right] != -1) {
                return dp[left][right];
            }
            
            dp[left][right] = n;
            int j = -1;
            
            for (int i = left; i < right; i++) {
                if (s[i] != s[right] && j == -1) {
                    j = i;
                }
                
                if (j != -1) {
                    dp[left][right] = min(dp[left][right], 1 + solve(j, i) + solve(i + 1, right));
                }
            }
            
            if (j == -1) {
                dp[left][right] = 0;
            }
            
            return dp[left][right];
        };

        return solve(0, n - 1) + 1;
    }
};