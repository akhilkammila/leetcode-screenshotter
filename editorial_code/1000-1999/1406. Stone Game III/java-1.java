class Solution {
    private int f(int[] stoneValue, int n, int i) {
        if (i == n) {
            return 0;
        }
        int result = stoneValue[i] - f(stoneValue, n, i + 1);
        if (i + 2 <= n) {
            result = Math.max(result, stoneValue[i]
                + stoneValue[i + 1] - f(stoneValue, n, i + 2));
        }
        if (i + 3 <= n) {
            result = Math.max(result, stoneValue[i] + stoneValue[i + 1]
                + stoneValue[i + 2] - f(stoneValue, n, i + 3));
        }
        return result;
    }

    public String stoneGameIII(int[] stoneValue) {
        int dif = f(stoneValue, stoneValue.length, 0);
        if (dif > 0) {
            return "Alice";
        }
        if (dif < 0) {
            return "Bob";
        }
        return "Tie";
    }
}