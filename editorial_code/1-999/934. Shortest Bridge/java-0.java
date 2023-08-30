class Solution {
    private List<int[]> bfsQueue;

    // Recursively check the neighboring land cell of current cell grid[x][y] and add all
    // land cells of island A to bfsQueue.
    private void dfs(int[][] grid, int x, int y, int n) {
        grid[x][y] = 2;
        bfsQueue.add(new int[]{x, y});
        for (int[] pair : new int[][]{{x + 1, y}, {x - 1, y}, {x, y + 1}, {x, y - 1}}) {
            int curX = pair[0], curY = pair[1];
            if (0 <= curX && curX < n && 0 <= curY && curY < n && grid[curX][curY] == 1) {
                dfs(grid, curX, curY, n);
            }
        }
    }
    
    // Find any land cell, and we treat it as a cell of island A.
    public int shortestBridge(int[][] grid) {    
        int n = grid.length;
        int firstX = -1, firstY = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    firstX = i;
                    firstY = j;
                    break;
                }
            }
        }
        
        // Add all land cells of island A to bfsQueue.
        bfsQueue = new ArrayList<>();
        dfs(grid, firstX, firstY, n);
        
        int distance = 0;
        while (!bfsQueue.isEmpty()) {
            List<int[]> newBfs = new ArrayList<>();
            for (int[] pair : bfsQueue) {
                int x = pair[0], y = pair[1];
                for (int[] nextPair : new int[][]{{x + 1, y}, {x - 1, y}, {x, y + 1}, {x, y - 1}}) {
                    int curX = nextPair[0], curY = nextPair[1];
                    if (0 <= curX && curX < n && 0 <= curY && curY < n) {
                        if (grid[curX][curY] == 1) {
                            return distance;
                        } else if (grid[curX][curY] == 0) {
                            newBfs.add(nextPair);
                            grid[curX][curY] = -1;
                        }
                    }
                }
            }

            // Once we finish one round without finding land cells of island B, we will
            // start the next round on all water cells that are 1 cell further away from
            // island A and increment the distance by 1.
            bfsQueue = newBfs;
            distance++;
        }
        
        return distance;
    }   
}