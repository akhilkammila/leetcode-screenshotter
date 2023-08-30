class Solution {
    public int numberOfArrays(String s, int k) {
        int m = s.length(), n = String.valueOf(k).length();
        int mod = 1_000_000_007;
        
        // dp[i] records the number of arrays that can be printed as
        // the prefix substring s[0 ~ i - 1]
        int[] dp = new int[m + 1];
        
        // Empty string has 1 valid split.
        dp[0] = 1;
        
        // Iterate over every digit, for each digit s[start]
        for (int start = 0; start < m; ++start) {
            if (s.charAt(start) == '0')
                continue;
            
            // Iterate over ending digit end and find all valid numbers 
            // s[start ~ end].
            for (int end = start; end < m; ++end) {
                String currNumber = s.substring(start, end + 1);
                
                if (Long.parseLong(currNumber) > k)
                    break;
                
                // If s[start ~ end] is valid, increment dp[end + 1] by dp[start].
                dp[end + 1] = (dp[end + 1] + dp[start]) % mod;
            }
        }
        return dp[m];
    }
}