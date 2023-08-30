class Solution {
public:
    int stoneGameII(vector<int>& piles) {
        int n = piles.size();
        vector dp(2, vector(n + 1, vector<int>(n + 1, -1)));
        
        function<int(int, int, int)> f = [&](int p, int i, int m) -> int {
            if (i == n) {
                return 0;
            }
            if (dp[p][i][m] != -1) {
                return dp[p][i][m];
            }
            int res = p == 1 ? 1000000 : -1, s = 0;
            for (int x = 1; x <= min(2 * m, n - i); x++) {
                s += piles[i + x - 1];
                if (p == 0) {
                    res = max(res, s + f(1, i + x, max(m, x)));
                }
                else {
                    res = min(res, f(0, i + x, max(m, x)));
                }
            }
            return dp[p][i][m] = res;
        };
        
        return f(0, 0, 1);
    }
};