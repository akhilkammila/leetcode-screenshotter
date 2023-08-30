class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        
        // Call helper function for complete strings
        return computeCost(s1, s2, s1.length()-1, s2.length()-1);
    }

    // Return minimum cost to make s1[0...i] and s2[0...j] equal
    private int computeCost(String s1, String s2, int i, int j) {

        // If s1 is empty, then we need to delete all characters of s2
        if (i < 0) {
            int deleteCost = 0;
            for (int pointer = 0; pointer <= j; pointer++) {
                deleteCost += s2.charAt(pointer);
            }
            return deleteCost;
        }

        // If s2 is empty, then we need to delete all characters of s1
        if (j < 0) {
            int deleteCost = 0;
            for (int pointer = 0; pointer <= i; pointer++) {
                deleteCost += s1.charAt(pointer);
            }
            return deleteCost;
        }

        // Check s1[i] and s2[j]
        if (s1.charAt(i) == s2.charAt(j)) {
            return computeCost(s1, s2, i-1, j-1);
        } else {
            return Math.min(
                s1.charAt(i) + computeCost(s1, s2, i-1, j),
                Math.min(
                    s2.charAt(j) + computeCost(s1, s2, i, j-1),
                    s1.charAt(i) + s2.charAt(j) + computeCost(s1, s2, i-1, j-1)
                )
            );
        }
    }
}