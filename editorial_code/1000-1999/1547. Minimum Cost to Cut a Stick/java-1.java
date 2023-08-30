class Solution {
    public int minCost(int n, int[] cuts) {
        int m = cuts.length;
        int[] newCuts = new int[m + 2];
        System.arraycopy(cuts, 0, newCuts, 1, m);
        newCuts[m + 1] = n;
        Arrays.sort(newCuts);
        
        int[][] dp = new int[m + 2][m + 2];
        
        for (int diff = 2; diff < m + 2; ++diff) {
            for (int left = 0; left < m + 2 - diff; ++left) {
                int right = left + diff;
                int ans = Integer.MAX_VALUE;
                for (int mid = left + 1; mid < right; ++mid) {
                    ans = Math.min(ans, dp[left][mid] + dp[mid][right] + newCuts[right] - newCuts[left]);
                }
                dp[left][right] = ans;
            }
        } 
        
        return dp[0][m + 1];
    }    
}