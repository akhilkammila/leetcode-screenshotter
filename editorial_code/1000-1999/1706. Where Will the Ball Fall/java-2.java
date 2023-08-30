class Solution {
    public int[] findBall(int[][] grid) {
        int result[] = new int[grid[0].length];

        for (int col = 0; col < grid[0].length; col++) {
            int currentCol = col;
            for (int row = 0; row < grid.length; row++) {
                int nextColumn = currentCol + grid[row][currentCol];
                if (nextColumn < 0 ||
                        nextColumn > grid[0].length - 1 ||
                        grid[row][currentCol] != grid[row][nextColumn]) {
                    result[col] = -1;
                    break;
                }
                result[col] = nextColumn;
                currentCol = nextColumn;
            }
        }
        return result;
    }
}