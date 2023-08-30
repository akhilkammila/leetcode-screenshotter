class Solution {
    HashMap<Integer, Integer> mark = new HashMap<>();
    int dp[][] = new int[2001][2001];
    
    boolean solve(int[] stones, int n, int index, int prevJump) {
        // If reached the last stone, return 1.
        if (index == n - 1) {
            return true;
        }
        
        // If this subproblem has already been calculated, return it.
        if (dp[index][prevJump] != -1) {
            return dp[index][prevJump] == 1;
        }
        
        boolean ans = false;
        // Iterate over the three possibilities {k - 1, k, k + 1}.
        for (int nextJump = prevJump - 1; nextJump <= prevJump + 1; nextJump++) {
            if (nextJump > 0 && mark.containsKey(stones[index] + nextJump)) {
                ans = ans || solve(stones, n, mark.get(stones[index] + nextJump), nextJump);
            }
        }

        // Store the result to fetch later.
        dp[index][prevJump] = (ans ? 1 :0);
        return ans;
    }
    
    public boolean canCross(int[] stones) {
        // Mark stones in the map to identify if such stone exists or not.
        for (int i = 0 ; i < stones.length; i++) {
            mark.put(stones[i], i);
        }
        
        //Mark all states as -1 to denote they're not calculated.
        for (int i = 0; i < 2000; i++) {
            Arrays.fill(dp[i], -1);
        }
        
        return solve(stones, stones.length, 0, 0);
    }
}