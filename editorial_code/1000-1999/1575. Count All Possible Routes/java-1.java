class Solution {
    public  int countRoutes(int[] locations, int start, int finish, int fuel) {
        int n = locations.length;
        int dp[][] = new int[n][fuel + 1];
        Arrays.fill(dp[finish], 1);

        int ans = 0;
        for (int j = 0; j <= fuel; j++) {
            for (int i = 0; i < n; i++) {
                for (int k = 0; k < n; k++) {
                    if (k == i) {
                        continue;
                    }
                    if (Math.abs(locations[i] - locations[k]) <= j) {
                        dp[i][j] = (dp[i][j] + dp[k][j - Math.abs(locations[i] - locations[k])]) %
                                   1000000007;
                    }
                }
            }
        }

        return dp[start][fuel];
    }
}