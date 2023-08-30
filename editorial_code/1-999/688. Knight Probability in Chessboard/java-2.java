class Solution {
    int[][] directions = {{1, 2}, {1, -2}, {-1, 2}, {-1, -2}, {2, 1}, {2, -1}, {-2, 1}, {-2, -1}};

    private double calculateDP(double[][][] dp, int moves, int i, int j, int n, int row, int column) {
        // Base case
        if (moves == 0) {
            if (i == row && j == column) {
                return 1;
            } else {
                return 0;
            }
        }

        // Check if the value has already been calculated
        if (dp[moves][i][j] != -1) {
            return dp[moves][i][j];
        }

        dp[moves][i][j] = 0;

        // Iterate over possible directions
        for (int[] direction : directions) {
            int prevI = i - direction[0];
            int prevJ = j - direction[1];

            // Boundary check
            if (prevI >= 0 && prevI < n && prevJ >= 0 && prevJ < n) {
                dp[moves][i][j] += calculateDP(dp, moves - 1, prevI, prevJ, n, row, column) / 8.0;
            }
        }

        return dp[moves][i][j];
    }

    public double knightProbability(int n, int k, int row, int column) {
        double[][][] dp = new double[k + 1][n][n];

        // Initialize dp with -1 values
        for (double[][] layer : dp) {
            for (double[] rowArray : layer) {
                Arrays.fill(rowArray, -1);
            }
        }

        // Calculate the total probability by summing up the probabilities for all cells
        double totalProbability = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                totalProbability += calculateDP(dp, k, i, j, n, row, column);
            }
        }

        return totalProbability;
    }
}