class Solution {
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        int firstX = -1, firstY = -1;
        
        // Find any land cell, and we treat it as a cell of island A.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    firstX = i;
                    firstY = j;
                    break;
                }
            }
        }

        // bfsQueue for BFS on land cells of island A; secondBfsQueue for BFS on water cells.
        List<int[]> bfsQueue = new ArrayList<>();
        List<int[]> secondBfsQueue = new ArrayList<>();
        bfsQueue.add(new int[]{firstX, firstY});
        secondBfsQueue.add(new int[]{firstX, firstY});
        grid[firstX][firstY] = 2;

        // BFS for all land cells of island A and add them to secondBfsQueue.
        while (!bfsQueue.isEmpty()) {
            List<int[]> newBfs = new ArrayList<>();
            for (int[] cell : bfsQueue) {
                int x = cell[0];
                int y = cell[1];
                for (int[] next : new int[][]{{x + 1, y}, {x - 1, y}, {x, y + 1}, {x, y - 1}}) {
                    int curX = next[0];
                    int curY = next[1];
                    if (curX >= 0 && curX < n && curY >= 0 && curY < n && grid[curX][curY] == 1) {
                        newBfs.add(new int[]{curX, curY});
                        secondBfsQueue.add(new int[]{curX, curY});
                        grid[curX][curY] = 2;
                    }
                }
            }
            bfsQueue = newBfs;
        }

        int distance = 0;
        while (!secondBfsQueue.isEmpty()) {
            List<int[]> newBfs = new ArrayList<>();
            for (int[] cell : secondBfsQueue) {
                int x = cell[0];
                int y = cell[1];
                for (int[] next : new int[][]{{x + 1, y}, {x - 1, y}, {x, y + 1}, {x, y - 1}}) {
                    int curX = next[0];
                    int curY = next[1];
                    if (curX >= 0 && curX < n && curY >= 0 && curY < n) {
                        if (grid[curX][curY] == 1) {
                            return distance;
                        } else if (grid[curX][curY] == 0) {
                            newBfs.add(new int[]{curX, curY});
                            grid[curX][curY] = -1;
                        }
                    }
                }
            }

            // Once we finish one round without finding land cells of island B, we will
            // start the next round on all water cells that are 1 cell further away from
            // island A and increment the distance by 1.
            secondBfsQueue = newBfs;
            distance++;
        }
        return distance;
    }
}