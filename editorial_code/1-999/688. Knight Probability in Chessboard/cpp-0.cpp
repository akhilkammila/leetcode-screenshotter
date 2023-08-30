class Solution {
public:
    double knightProbability(int n, int k, int row, int column) {
        // Define possible directions for the knight's moves
        vector<pair<int, int>> directions = {{1, 2}, {1, -2}, {-1, 2}, {-1, -2},
                                            {2, 1}, {2, -1}, {-2, 1}, {-2, -1}};

        // Initialize the dynamic programming table
        vector dp(k + 1, vector (n, vector<double>(n, 0.0)));
        dp[0][row][column] = 1;

        // Iterate over the number of moves
        for (int moves = 1; moves <= k; moves++) {
            // Iterate over the cells on the chessboard
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // Iterate over possible directions
                    for (const auto& direction : directions) {
                        int prevI = i - direction.first;
                        int prevJ = j - direction.second;
                        // Check if the previous cell is within the chessboard
                        if (prevI >= 0 && prevI < n && prevJ >= 0 && prevJ < n) {
                            // Add the previous probability divided by 8
                            dp[moves][i][j] += dp[moves - 1][prevI][prevJ] / 8;
                        }
                    }
                }
            }
        }

        // Calculate total probability by summing probabilities for all cells
        double totalProbability = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                totalProbability += dp[k][i][j];
            }
        }

        return totalProbability;
    }
};