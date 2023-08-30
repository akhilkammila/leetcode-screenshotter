class Solution {
    long dp[];
    private long dfs(int[][] questions, int i) {
        if (i >= questions.length) {
            return 0;
        }
        if (dp[i] != 0) {
            return dp[i];
        }
        long points = questions[i][0];
        int skip = questions[i][1];

        // dp[i] = max(skip it, solve it)
        dp[i] = Math.max(points + dfs(questions, i + skip + 1), dfs(questions, i + 1));
        return dp[i];
    }
    
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        dp = new long[n];
        
        return dfs(questions, 0);
    }
}