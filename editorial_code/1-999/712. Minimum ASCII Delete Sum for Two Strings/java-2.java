class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        
        // Pre-compute sum of ASCII values of s1
        int m = s1.length();
        int[] s1_ascii_sum = new int[m];
        s1_ascii_sum[0] = s1.charAt(0);
        for (int i = 1; i < m; i++) {
            s1_ascii_sum[i] = s1.charAt(i) + s1_ascii_sum[i-1];
        }

        // Pre-compute sum of ASCII values of s2
        int n = s2.length();
        int[] s2_ascii_sum = new int[n];
        s2_ascii_sum[0] = s2.charAt(0);
        for (int i = 1; i < n; i++) {
            s2_ascii_sum[i] = s2.charAt(i) + s2_ascii_sum[i-1];
        }
        
        // Two-dimensional array to store the result of each sub-problem.
        // Initialize with -1.
        int[][] savedResult = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(savedResult[i], -1);
        }

        // Return minimum cost to make s1[0...i] and s2[0...j] equal
        return computeCost(s1, s2, m-1, n-1, savedResult, s1_ascii_sum, s2_ascii_sum);
    }

    private int computeCost(String s1, String s2, int i, int j, int[][] savedResult, int[] s1_ascii_sum, int[] s2_ascii_sum) {

        // If both strings are empty, then no deletion is required
        if (i < 0 && j < 0) {
            return 0;
        }
        
        // If any one string is empty, delete all characters of the other string
        if (i < 0) {
            return s2_ascii_sum[j];
        }
        if (j < 0) {
            return s1_ascii_sum[i];
        }
        
        // If already computed, then return the result
        if (savedResult[i][j] != -1) {
            return savedResult[i][j];
        }
        
        // Call sub-problem depending on s1[i] and s2[j]
        // Save the computed result.
        if (s1.charAt(i) == s2.charAt(j)) {
            savedResult[i][j] = computeCost(s1, s2, i-1, j-1, savedResult, s1_ascii_sum, s2_ascii_sum);
            return savedResult[i][j];
        } else {
            savedResult[i][j] = Math.min(
                s1.charAt(i) + computeCost(s1, s2, i-1, j, savedResult, s1_ascii_sum, s2_ascii_sum),
                s2.charAt(j) + computeCost(s1, s2, i, j-1, savedResult, s1_ascii_sum, s2_ascii_sum)
            );
            return savedResult[i][j];
        }
    }
}