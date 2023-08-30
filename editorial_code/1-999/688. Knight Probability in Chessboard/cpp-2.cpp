class Solution {
public:
    double knightProbability(int n, int k, int row, int column) {
        vector<pair<int, int>> directions = {{1, 2}, {1, -2}, {-1, 2}, {-1, -2}, {2, 1}, {2, -1}, {-2, 1}, {-2, -1}};
        vector dp(k + 1, vector (n, vector<double>(n, -1)));

        function<double(int, int, int)> calculateDP = [&](int moves, int i, int j) -> double {
            // Base case
            if (moves == 0) {
                if (i == row && j == column) {
                    return 1;
                } else {
                    return 0;
                }
            }

            // Check if value has already been calculated
            if (dp[moves][i][j] != -1) {
                return dp[moves][i][j];
            }

            dp[moves][i][j] = 0;

            // Iterate over possible directions
            for (const auto& direction : directions) {
                int prevI = i - direction.first;
                int prevJ = j - direction.second;

                // Boundary check
                if (prevI >= 0 && prevI < n && prevJ >= 0 && prevJ < n) {
                    dp[moves][i][j] += calculateDP(moves - 1, prevI, prevJ) / 8.0;
                }
            }

            return dp[moves][i][j];
        };

        // Calculate the total probability by summing up the probabilities for all cells
        double totalProbability = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                totalProbability += calculateDP(k, i, j);
            }
        }

        return totalProbability;
    }
};