class Solution {
public:
    int countNegatives(vector<vector<int>>& grid) {
        int count = 0;
        int n = grid[0].size();
        // Iterate on all rows of the matrix one by one.
        for (auto& row : grid) {
            // Using binary search find the index of the first negative element.
            int index = upper_bound(row.begin(), row.end(), 0, greater<int>()) - row.begin();
            // 'index' points to the first negative element,
            // which means 'n - index' is the number of all negative elements.
            count += (n - index);
        }
        return count;
    }
};