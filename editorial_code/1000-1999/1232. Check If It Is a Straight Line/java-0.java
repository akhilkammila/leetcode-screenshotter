class Solution {
    // Returns the delta Y.
    int getYDiff(int[] a, int[] b) {
        return a[1] - b[1];
    }
    
    // Returns the delta X.
    int getXDiff(int[] a, int[] b) {
        return a[0] - b[0];
    }
    
    public boolean checkStraightLine(int[][] coordinates) {
        int deltaY = getYDiff(coordinates[1], coordinates[0]);
        int deltaX = getXDiff(coordinates[1], coordinates[0]);
        
        for (int i = 2; i < coordinates.length; i++) {
            // Check if the slope between points 0 and i, is the same as between 0 and 1.
            if (deltaY * getXDiff(coordinates[i], coordinates[0])
                != deltaX * getYDiff(coordinates[i], coordinates[0])) {
                return false;
            }
        }
        return true;
    }
}