class Solution {
    public int ways(String[] pizza, int k) {
        int rows = pizza.length, cols = pizza[0].length();
        int apples[][] = new int[rows + 1][cols + 1];
        int f[][] = new int[rows][cols];
        for (int row = rows - 1; row >= 0; row--) {
            for (int col = cols - 1; col >= 0; col--) {
                apples[row][col] = (pizza[row].charAt(col) == 'A' ? 1 : 0) + apples[row + 1][col] + apples[row][col + 1]
                        - apples[row + 1][col + 1];
                f[row][col] = apples[row][col] > 0 ? 1 : 0;
            }
        }
        int mod = 1000000007;
        for (int remain = 1; remain < k; remain++) {
            int g[][] = new int[rows][cols];
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    for (int next_row = row + 1; next_row < rows; next_row++) {
                        if (apples[row][col] - apples[next_row][col] > 0) {
                            g[row][col] += f[next_row][col];
                            g[row][col] %= mod;
                        }
                    }
                    for (int next_col = col + 1; next_col < cols; next_col++) {
                        if (apples[row][col] - apples[row][next_col] > 0) {
                            g[row][col] += f[row][next_col];
                            g[row][col] %= mod;
                        }
                    }
                }
            }
            // copy g to f
            f = Arrays.stream(g).map(int[]::clone).toArray(int[][]::new);
        }
        return f[0][0];
    }
}