class Solution {
    public long maxPoints(int[][] points) {
        final int n = points[0].length;
        long[] lastDp = Arrays.stream(points[0]).mapToLong(x -> x).toArray();
        for (int i = 1; i < points.length; ++i) {
            long[] currentDp = new long[n];
            long temp = 0;
            for (int j = 0; j < n; ++j) {
                temp = Math.max(temp, lastDp[j] + j);
                currentDp[j] = temp - j + points[i][j];
            }
            temp = -n;
            for (int j = n - 1; j >= 0; --j) {
                temp = Math.max(temp, lastDp[j] - j);
                currentDp[j] = Math.max(currentDp[j], temp + j + points[i][j]);
            }
            lastDp = currentDp;
        }
        long ans = lastDp[0];
        for (long x : lastDp) {
            ans = Math.max(ans, x);
        }
        return ans;
    }
}