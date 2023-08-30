class Solution {

    // Hash Map to store the result of each sub-problem.
    Map<Pair<Integer, Integer>, Integer> savedResult = new HashMap<>();
        
    public int minimumDeleteSum(String s1, String s2) {
        
        // Return minimum cost to make s1[0...i] and s2[0...j] equal
        return computeCost(s1, s2, s1.length()-1, s2.length()-1);
    }

    private int computeCost(String s1, String s2, int i, int j) {

        // If both strings are empty, then no deletion is required
        if (i < 0 && j < 0) {
            return 0;
        }

        // If already computed, then return the result from the hash map
        Pair<Integer, Integer> key = new Pair<>(i, j);
        if (savedResult.containsKey(key)) {
            return savedResult.get(key);
        }
        
        // If any one string is empty, delete all characters of the other string
        if (i < 0) {
            savedResult.put(key, s2.charAt(j) + computeCost(s1, s2, i, j-1));
            return savedResult.get(key);
        }
        if (j < 0) {
            savedResult.put(key, s1.charAt(i) + computeCost(s1, s2, i-1, j));
            return savedResult.get(key);
        }
        
        // Call sub-problem depending on s1[i] and s2[j]
        // Save the computed result.
        if (s1.charAt(i) == s2.charAt(j)) {
            savedResult.put(key, computeCost(s1, s2, i-1, j-1));
        } else {
            savedResult.put(key, Math.min(
                s1.charAt(i) + computeCost(s1, s2, i-1, j),
                s2.charAt(j) + computeCost(s1, s2, i, j-1)
            ));
        }
        return savedResult.get(key);
    }
}