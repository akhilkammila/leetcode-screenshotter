class Solution {
    int[][] memo;
    int done;
    int n;
    int MOD = 1000000007;
    Map<Integer, ArrayList<Integer>> hatsToPeople;
    
    public int numberWays(List<List<Integer>> hats) {
        n = hats.size();
        
        hatsToPeople = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int hat: hats.get(i)) {
                if (!hatsToPeople.containsKey(hat)) {
                    hatsToPeople.put(hat, new ArrayList<>());
                }
                
                hatsToPeople.get(hat).add(i);
            }
        }
        
        done = (int) Math.pow(2, n) - 1;
        memo = new int[41][done];
        
        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[i].length; j++) {
                memo[i][j] = -1;
            }
        }
        
        return dp(1, 0);
    }
    
    private int dp(int hat, int mask) {
        if (mask == done) {
            return 1;
        }
        
        if (hat > 40) {
            return 0;
        }
        
        if (memo[hat][mask] != -1) {
            return memo[hat][mask];
        }
        
        int ans = dp(hat + 1, mask);
        
        if (hatsToPeople.containsKey(hat)) {
            for (int person: hatsToPeople.get(hat)) {
                if ((mask & (1 << person)) == 0) {
                    ans = (ans + dp(hat + 1, mask | (1 << person))) % MOD;
                }
            }
        }
        
        memo[hat][mask] = ans;
        return ans;
    }
}