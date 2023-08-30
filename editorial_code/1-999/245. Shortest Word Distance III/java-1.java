class Solution {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        List<Pair<Integer, Integer>> indices = new ArrayList<>();

        // Store the indices of word1 or word2 and an extra integer in the pair
        // as 0 if the string is word1 or 1 if the string is word2.
        for (int i = 0; i < wordsDict.length; i++) {
            if (wordsDict[i].equals(word1)) {
                indices.add(new Pair(i, 0));
            }
            if (wordsDict[i].equals(word2)) {
                indices.add(new Pair(i, 1));
            }
        }

        // Initialize it to maximum integer as it will store the minimum distance.
        int shortestDistance = Integer.MAX_VALUE;
        for (int i = 0; i < indices.size() - 1; i++) {
            // If the two consecutive pairs have both different values
            if (!indices.get(i).getValue().equals(indices.get(i + 1).getValue())
                    && !indices.get(i).getKey().equals(indices.get(i + 1).getKey())) {
                // Find the difference between indices and update shortestDistance
                shortestDistance = Math.min(shortestDistance, indices.get(i + 1).getKey() - indices.get(i).getKey());
            }
        }
        return shortestDistance;
    }
}