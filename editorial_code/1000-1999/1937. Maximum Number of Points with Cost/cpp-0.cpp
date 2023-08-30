class Solution {
public:
    long long maxPoints(vector<vector<int>>& points) {
        const int n = int(points[0].size());
        vector<vector<long long>> dp(2, vector<long long>(n));
        for (int i = 0; i < n; ++i) {
            dp[0][i] = points[0][i];
        }
        int last = 0;
        for (int i = 1; i < points.size(); ++i) {
            int now = last ^ 1;
            long long temp = 0;
            for (int j = 0; j < n; ++j) {
                temp = max(temp, dp[last][j] + j);
                dp[now][j] = temp - j + points[i][j];
            }
            temp = -n;
            for (int j = n - 1; j >= 0; --j) {
                temp = max(temp, dp[last][j] - j);
                dp[now][j] = max(dp[now][j], temp + j + points[i][j]);
            }
            last = now;
        }
        return *max_element(dp[last].begin(), dp[last].end());
    }
};
