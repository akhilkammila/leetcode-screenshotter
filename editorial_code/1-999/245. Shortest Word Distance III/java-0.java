class Solution {
    // Returns the index pointing to the first element in the range [0, N - 1]
    // that is greater than value, or N if no such element is found
    int upper_bound(List<Integer> indices, int value) {
        int N = indices.size();

        int left = 0, right = N - 1;
        int index = N;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (indices.get(mid) > value) {
                index = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return index;
    }

    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        List<Integer> indices1 = new ArrayList<>();
        List<Integer> indices2 = new ArrayList<>();

        // Store the indices of word1 in the list indices1 and indices of word2 in the list indices2.
        for (int i = 0; i < wordsDict.length; i++) {
            if (wordsDict[i].equals(word1)) {
                indices1.add(i);
            }
            if (wordsDict[i].equals(word2)) {
                indices2.add(i);
            }
        }

        // Initialize it to maximum integer as it will store the minimum distance.
        int shortestDistance = Integer.MAX_VALUE;
        // Iterate over the indices of word1
        for (int index : indices1) {
            // Find the next greater index in the list indices2
            int x = upper_bound(indices2, index);

            if (x != indices2.size()) {
                // If x is not pointing to the last iterator, find the difference between these two indices
                shortestDistance = Math.min(shortestDistance, indices2.get(x) - index);
            }

            if (x != 0 && indices2.get(x - 1) != index) {
                // Find difference betwee index and indices[x - 1], if x > 0 and the indices are not the same.
                shortestDistance = Math.min(shortestDistance, index - indices2.get(x - 1));
            }
        }

        return shortestDistance;
    }
}