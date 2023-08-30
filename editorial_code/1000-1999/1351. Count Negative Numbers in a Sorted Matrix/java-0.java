class Solution {
    public int countNegatives(int[][] grid) {
        int count = 0;
        // Iterate on all elements of the matrix one by one.
        for (int[] row : grid) {
            for (int element : row) {
                // If the current element is negative, we count it.
                if (element < 0) {
                    count++;
                }
            }
        }
        return count;
    }
}