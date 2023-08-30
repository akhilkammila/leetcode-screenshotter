class Solution {
    public int countPaths(int[][] grid) {
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int m = grid.length, n = grid[0].length;
        int mod = 1_000_000_007;
        
        // Initialize dp, 1 stands for the path made by a cell itself.
        int[][] dp = new int[m][n];
        Arrays.stream(dp).forEach(row -> Arrays.fill(row, 1));
        
        // Sort all cells by value.
        int[][] cellList = new int[m * n][2];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int index = i * n + j;
                cellList[index][0] = i;
                cellList[index][1] = j;
            }      
        }
        Arrays.sort(cellList, (a, b) -> grid[a[0]][a[1]] - grid[b[0]][b[1]]);
        
        // Iterate over the sorted cells, for each cell grid[i][j]: 
        for (int[] cell : cellList) {
            int i = cell[0], j = cell[1];

            // Check its four neighbor cells, if a neighbor cell grid[currI][currJ] has a
            // larger value, increment dp[currI][currJ] by dp[i][j]
            for (int[] d : directions) {
                int currI = i + d[0], currJ = j + d[1];
                if (0 <= currI && currI < m && 0 <= currJ && currJ < n
                   && grid[currI][currJ] > grid[i][j]) {
                    dp[currI][currJ] += dp[i][j];
                    dp[currI][currJ] %= mod;
                }
            }
        }
        
        // Sum over dp[i][j].
        int answer = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                answer += dp[i][j];
                answer %= mod;
            }
        }
        return answer;
    }
}