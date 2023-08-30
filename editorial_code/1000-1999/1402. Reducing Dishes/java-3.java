class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);

        int maxSatisfaction = 0;
        int suffixSum = 0;
        for (int i = satisfaction.length - 1; i >= 0 && suffixSum + satisfaction[i] > 0; i--) {
            // Total satisfaction with all dishes so far.
            suffixSum += satisfaction[i];
            // Adding one instance of previous dishes as we add one more dish on the left.
            maxSatisfaction +=  suffixSum;
        }
        return maxSatisfaction;
    }
}