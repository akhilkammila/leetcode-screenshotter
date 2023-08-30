class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        
        // Prepare the two-dimensional array
        int m = s1.length(), n = s2.length();
        int[][] computeCost = new int[m + 1][n + 1];

        // Fill in the base case values
        for (int i = 1; i <= m; i++) {
            computeCost[i][0] = computeCost[i-1][0] + s1.charAt(i-1);
        }
        for (int j = 1; j <= n; j++) {
            computeCost[0][j] = computeCost[0][j-1] + s2.charAt(j-1);
        }
        
        // Fill the remaining cells using the Bellman Equation
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    computeCost[i][j] = computeCost[i-1][j-1];
                } else {
                    computeCost[i][j] = Math.min(
                        s1.charAt(i-1) + computeCost[i-1][j],
                        s2.charAt(j-1) + computeCost[i][j-1]
                    );
                }
            }
        }
        
        // Return the answer for entire input strings
        return computeCost[m][n];
    }
}