class Solution {
    private int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public boolean canCross(int row, int col, int[][] cells, int day) {
        int[][] grid = new int[row][col];
        for (int i = 0; i < day; ++i) {
            int r = cells[i][0] - 1, c = cells[i][1] - 1;
            grid[r][c] = 1;
        }
        
        for (int i = 0; i < day; ++i) {
            grid[cells[i][0] - 1][cells[i][1] - 1] = 1;
        }
        
        for (int i = 0; i < col; ++i) {
            if (grid[0][i] == 0 && dfs(grid, 0, i, row, col)) {
                return true;
            }
        }
        return false;
        
    }

    private boolean dfs(int[][] grid, int r, int c, int row, int col) {
        if (r < 0 || r >= row || c < 0 || c >= col || grid[r][c] != 0) {
            return false;
        }
        if (r == row - 1) {
            return true;
        }
        grid[r][c] = -1;
        for (int[] dir : directions) {
            int newR = r + dir[0], newC = c + dir[1];
            if (dfs(grid, newR, newC, row, col)) {
                return true;
            }
        }
        return false;
    }

    public int latestDayToCross(int row, int col, int[][] cells) {
        int left = 1, right = row * col;
        while (left < right) {
            int mid = right - (right - left) / 2;
            if (canCross(row, col, cells, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}