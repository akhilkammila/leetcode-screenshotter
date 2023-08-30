class Solution {
    public double soupServings(int n) {
        int m = (int)Math.ceil(n / 25.0);
        Map<Integer, Map<Integer, Double>> dp = new HashMap<>();

        for (int k = 1; k <= m; k++) {
            if (calculateDP(k, k, dp) > 1 - 1e-5) {
                return 1.0;
            }
        }
        return calculateDP(m, m, dp);
    }

    private double calculateDP(int i, int j, Map<Integer, Map<Integer, Double>> dp) {
        if (i <= 0 && j <= 0) {
            return 0.5;
        }
        if (i <= 0) {
            return 1.0;
        }
        if (j <= 0) {
            return 0.0;
        }
        if (dp.containsKey(i) && dp.get(i).containsKey(j)) {
            return dp.get(i).get(j);
        }
        double result = (calculateDP(i - 4, j, dp) + calculateDP(i - 3, j - 1, dp) +
                calculateDP(i - 2, j - 2, dp) + calculateDP(i - 1, j - 3, dp)) / 4.0;
        dp.computeIfAbsent(i, k -> new HashMap<>()).put(j, result);
        return result;
    }
}