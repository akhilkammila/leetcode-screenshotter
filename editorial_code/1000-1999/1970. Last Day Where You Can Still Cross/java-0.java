class Solution {
    private int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public boolean canCross(int row, int col, int[][] cells, int day) {
        int[][] grid = new int[row][col];
        Queue<int[]> queue = new LinkedList<>();
        
        for (int i = 0; i < day; i++) {
            grid[cells[i][0] - 1][cells[i][1] - 1] = 1;
        }
        
        for (int i = 0; i < col; i++) {
            if (grid[0][i] == 0) {
                queue.offer(new int[]{0, i});
                grid[0][i] = -1;
            }
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0], c = cur[1];
            if (r == row - 1) {
                return true;
            }
            
            for (int[] dir : directions) {
                int newRow = r + dir[0];
                int newCol = c + dir[1];
                if (newRow >= 0 && newRow < row && newCol >= 0 && newCol < col && grid[newRow][newCol] == 0) {
                    grid[newRow][newCol] = -1;
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }
        
        return false;
    }
    
    public int latestDayToCross(int row, int col, int[][] cells) {
        int left = 1;
        int right = row * col;
        
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