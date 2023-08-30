class Solution {
    public static int bisectRight(int[][] events, int target) {
        int left = 0, right = events.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (events[mid][0] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    } 
    
    public int maxValue(int[][] events, int k) {
        int n = events.length;
        int[][] dp = new int[k + 1][n + 1];
        Arrays.sort(events, (a, b) -> a[0] - b[0]);

        for (int curIndex = n - 1; curIndex >= 0; --curIndex) {
            for (int count = 1; count <= k; count++) {
                int nextIndex = bisectRight(events, events[curIndex][1]);
                dp[count][curIndex] = Math.max(dp[count][curIndex + 1], events[curIndex][2] + dp[count - 1][nextIndex]);
            }
        }
        return dp[k][0];
    }
}