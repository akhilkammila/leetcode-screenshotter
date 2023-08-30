class Solution {
public:
    bool stoneGame(vector<int>& piles) {
        int N = piles.size();

        // dp[i+1][j+1] = the value of the game [piles[i], ..., piles[j]]
        int dp[N+2][N+2];
        memset(dp, 0, sizeof(dp));

        for (int size = 1; size <= N; ++size)
            for (int i = 0, j = size - 1; j < N; ++i, ++j) {
                int parity = (j + i + N) % 2;  // j - i - N; but +x = -x (mod 2)
                if (parity == 1)
                    dp[i+1][j+1] = max(piles[i] + dp[i+2][j+1], piles[j] + dp[i+1][j]);
                else
                    dp[i+1][j+1] = min(-piles[i] + dp[i+2][j+1], -piles[j] + dp[i+1][j]);
            }

        return dp[1][N] > 0;
    }
};