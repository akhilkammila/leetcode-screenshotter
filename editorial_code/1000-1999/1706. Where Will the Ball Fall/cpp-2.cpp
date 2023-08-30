class Solution {
public:
    vector<int> findBall(vector<vector<int>>& grid) {
        vector<int> result(grid[0].size(), 0);

        for (int col = 0; col < grid[0].size(); col++) {
            int currentCol = col;
            for (int row = 0; row < grid.size(); row++) {
                int nextColumn = currentCol + grid[row][currentCol];
                if (nextColumn < 0 || nextColumn > grid[0].size() - 1 ||
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
};
