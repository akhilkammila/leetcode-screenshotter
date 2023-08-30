class Solution {
public:
    int countNegatives(vector<vector<int>>& grid) {
        int count = 0;
        // Iterate on all elements of the matrix one by one.
        for (auto& row : grid) {
            for (auto& element : row) {
                // If the current element is negative, we count it.
                if (element < 0) {
                    count++;
                }
            }
        }
        return count;
    }
};