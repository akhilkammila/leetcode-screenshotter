class Solution {
    public List<Integer> mostSimilar(int n, int[][] roads, String[] names,
            String[] targetPath) {
        Integer[][] dp = new Integer[targetPath.length][n];
        int[][] p = new int[targetPath.length][n];
        // initialize DP
        for (int i = 0; i < n; i++) {
            dp[0][i] = names[i].equals(targetPath[0]) ? 0 : 1;
        }
        // calculate DP
        for (int i = 1; i < targetPath.length; i++) {
            Arrays.fill(dp[i], targetPath.length + 1);
            for (int[] road : roads) {
                // consider both edges (u, v) and (v, u)
                for (int j = 0; j < 2; j++) {
                    int u = road[j], v = road[j ^ 1],
                            cur = dp[i - 1][u] + (names[v].equals(targetPath[i]) ? 0 : 1);
                    if (cur < dp[i][v]) {
                        dp[i][v] = cur;
                        p[i][v] = u;
                    }
                }
            }
        }
        List<Integer> lastDP = Arrays.asList(dp[targetPath.length - 1]);
        // the last vertex in the path
        int v = lastDP.indexOf(Collections.min(lastDP));
        List<Integer> ans = new ArrayList<Integer>();
        ans.add(v);
        for (int i = targetPath.length - 1; i > 0; i--) {
            // the previous vertex in the path
            v = p[i][v];
            ans.add(v);
        }
        Collections.reverse(ans);
        return ans;
    }
}