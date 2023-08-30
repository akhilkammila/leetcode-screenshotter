class Solution {
    HashMap<Integer,Integer> mark = new HashMap<Integer,Integer>();
    boolean dp[][] = new boolean[2001][2001];

    public boolean canCross(int[] stones) {
        int n = stones.length;
        // Mark stones in the map to identify if such stone exists or not.
        for (int i = 0 ; i < n; i++) {
            mark.put(stones[i], i);
        }

        dp[0][0] = true;
        for (int index = 0; index < n; index++) {
            for (int prevJump = 0; prevJump <= n; prevJump++) {
                // If stone exists, mark the value with position and jump as 1.
                if (dp[index][prevJump]) {
                    if (mark.containsKey(stones[index] + prevJump)) {
                        dp[mark.get(stones[index] + prevJump)][prevJump] = true;
                    }
                    if (mark.containsKey(stones[index] + prevJump + 1)) {
                        dp[mark.get(stones[index] + prevJump + 1)][prevJump + 1] = true;
                    }
                    if (mark.containsKey(stones[index] + prevJump - 1)) {
                        dp[mark.get(stones[index] + prevJump - 1)][prevJump - 1] = true;
                    }
                }


            }
        }

        // If any value with index as n - 1 is true, return true.
        for (int index = 0; index <= n; index++) {
            if (dp[n - 1][index]) {
                return true;
            }
        }
        return false;
    }
}