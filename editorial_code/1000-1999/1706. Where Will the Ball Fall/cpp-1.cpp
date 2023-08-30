class Solution {
public:
    vector<int> findBall(vector<vector<int>>& grid) {
        vector<int> result(grid[0].size(), 0);
        vector<vector<int>> memo(grid.size() + 1, vector<int>(grid[0].size(), 0));

        for (int row = int(grid.size()); row >= 0; row--) {
            for (int col = 0; col < grid[0].size(); col++) {
                if (row == grid.size()) {
                    memo[row][col] = col;
                    continue;
                }
                int nextColumn = col + grid[row][col];
                if (nextColumn < 0 || nextColumn > grid[0].size() - 1 ||
                    grid[row][col] != grid[row][nextColumn])
                    memo[row][col] = -1;
                else
                    memo[row][col] = memo[row + 1][nextColumn];
                if (row == 0) {
                    result[col] = memo[row][col];
                }
            }
        }
        return result;
    }
};
