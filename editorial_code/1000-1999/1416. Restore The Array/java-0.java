class Solution {
    int mod = 1_000_000_007;

    // Number of possible splits for substring s[start ~ m-1].
    private int dfs(int[] dp, int start, String s, int k) {
        // If we have already updated dp[start], return it.
        if (dp[start] != 0)
            return dp[start];

        // There is only 1 split for an empty string.
        if (start == s.length())
            return 1;

        // Number can't have leading zeros.
        if (s.charAt(start) == '0')
            return 0;

        // For all possible starting number, add the number of arrays 
        // that can be printed as the remaining string to count.
        int count = 0;
        for (int end = start; end < s.length(); ++end) {
            String currNumber = s.substring(start, end + 1);
            if (Long.parseLong(currNumber) > k)
                break;
            count = (count + dfs(dp, end + 1, s, k)) % mod;
        }

        // Update dp[start] so we don't recalculate it later.
        dp[start] = count;
        return count;
    }
    
    public int numberOfArrays(String s, int k) {
        int m = s.length();
        int[] dp = new int[m + 1];
        return dfs(dp, 0, s, k);
    }
}