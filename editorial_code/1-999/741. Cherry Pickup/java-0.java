class Solution {
    public int cherryPickup(int[][] grid) {
        int ans = 0;
        int[][] path = bestPath(grid);
        if (path == null) return 0;
        for (int[] step: path) {
            ans += grid[step[0]][step[1]];
            grid[step[0]][step[1]] = 0;
        }

        for (int[] step: bestPath(grid))
            ans += grid[step[0]][step[1]];

        return ans;
    }

    public int[][] bestPath(int[][] grid) {
        int N = grid.length;
        int[][] dp = new int[N][N];
        for (int[] row: dp) Arrays.fill(row, Integer.MIN_VALUE);
        dp[N-1][N-1] = grid[N-1][N-1];
        for (int i = N-1; i >= 0; --i) {
            for (int j = N-1; j >= 0; --j) {
                if (grid[i][j] >= 0 && (i != N-1 || j != N-1)) {
                    dp[i][j] = Math.max(i+1 < N ? dp[i+1][j] : Integer.MIN_VALUE,
                                        j+1 < N ? dp[i][j+1] : Integer.MIN_VALUE);
                    dp[i][j] += grid[i][j];
                }
            }
        }
        if (dp[0][0] < 0) return null;
        int[][] ans = new int[2*N - 1][2];
        int i = 0, j = 0, t = 0;
        while (i != N-1 || j != N-1) {
            if (j+1 == N || i+1 < N && dp[i+1][j] >= dp[i][j+1]) i++;
            else j++;

            ans[t][0] = i;
            ans[t][1] = j;
            t++;
        }
        return ans;
    }
}