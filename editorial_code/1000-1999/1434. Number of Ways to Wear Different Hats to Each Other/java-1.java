class Solution {
    public int numberWays(List<List<Integer>> hats) {
        int n = hats.size();
        Map<Integer, ArrayList<Integer>> hatsToPeople = new HashMap<>();
        
        hatsToPeople = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int hat: hats.get(i)) {
                if (!hatsToPeople.containsKey(hat)) {
                    hatsToPeople.put(hat, new ArrayList<>());
                }
                
                hatsToPeople.get(hat).add(i);
            }
        }
        
        int done = (int) Math.pow(2, n) - 1;
        int MOD = 1000000007;
        
        int[][] dp = new int[42][done + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][done] = 1;
        }
        
        for (int hat = 40; hat > 0; hat--) {
            for (int mask = done; mask >= 0; mask--) {
                int ans = dp[hat + 1][mask];
                if (hatsToPeople.containsKey(hat)) {
                    for (int person: hatsToPeople.get(hat)) {
                        if ((mask & (1 << person)) == 0) {
                            ans = (ans + dp[hat + 1][mask | (1 << person)]) % MOD;
                        }
                    }
                }
                
                dp[hat][mask] = ans;
            }
        }

        return dp[1][0];
    }
}