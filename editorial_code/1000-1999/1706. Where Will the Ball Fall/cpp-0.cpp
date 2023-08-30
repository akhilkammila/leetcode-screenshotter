class Solution {
public:
    vector<int> findBall(vector<vector<int>>& grid) {
        vector<int> result(grid[0].size(), 0);
        for (int i = 0; i < grid[0].size(); i++) {
            result[i] = findBallDropColumn(0, i, grid);
        }
        return result;
    }

    int findBallDropColumn(int row, int col, vector<vector<int>>& grid) {
        // base case; ball reached the last row
        if (row == grid.size()) return col;
        int nextColumn = col + grid[row][col];
        if (nextColumn < 0 || nextColumn > grid[0].size() - 1 ||
            grid[row][col] != grid[row][nextColumn]) {
            return -1;
        }
        return findBallDropColumn(row + 1, nextColumn, grid);
    }
};
