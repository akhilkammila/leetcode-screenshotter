class Solution {
    private double findProbability(int index, int n, double[][] memo, double[] prob, int target) {
        // Return 0 if the target is less than zero because we have more heads
        // than we need.
        if (target < 0) {
            return 0;
        }
        // After tossing all of the coins, if we get the required number of heads,
        // return 1 to count this case, otherwise return 0.
        if (index == n) {
            return target == 0 ? 1 : 0;
        }

        if (memo[index][target] != -1) {
            return memo[index][target];
        }

        memo[index][target] = findProbability(index + 1, n, memo, prob, target - 1) * prob[index] +
                              findProbability(index + 1, n, memo, prob, target) * (1 - prob[index]);

        return memo[index][target];
    }

    public double probabilityOfHeads(double[] prob, int target) {
        int n = prob.length;
        double[][] memo = new double[n][target + 1];
        for (double[] row : memo) {
            Arrays.fill(row, -1);
        }

        return findProbability(0, n, memo, prob, target);
    }
}
