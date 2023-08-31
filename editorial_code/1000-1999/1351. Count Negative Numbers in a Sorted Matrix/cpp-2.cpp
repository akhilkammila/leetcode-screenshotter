class Solution {
public:
    int countNegatives(vector<vector<int>>& grid) {
        int count = 0;
        int n = grid[0].size();
        int currRowNegativeIndex = n - 1;

        // Iterate on all rows of the matrix one by one.
        for (auto& row : grid) {
            // Decrease 'currRowNegativeIndex' so that it points to current row's last positive element.
            while (currRowNegativeIndex >= 0 && row[currRowNegativeIndex] < 0) {
                currRowNegativeIndex--;
            }
            // 'currRowNegativeIndex' points to the last positive element,
            // which means 'n - (currRowNegativeIndex + 1)' is the number of all negative elements.
            count += (n - (currRowNegativeIndex + 1));
        }
        return count;
    }
};