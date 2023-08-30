class Solution {
    public int numberOfArrays(String s, int k) {
        int m = s.length(), n = String.valueOf(k).length();
        int mod = 1_000_000_007;
        
        // dp[i % (n + 1)] stands for the number of splits for substring s[0 ~ i - 1]
        int[] dp = new int[n + 1];
        
        // Empty string has 1 valid split.
        dp[0] = 1;
        
        // Iterate over every digit, for each digit s[start]
        for (int start = 0; start < m; ++start) {
            if (s.charAt(start) == '0') {
                dp[start % (n + 1)] = 0;
                continue;
            }
            
            // We travers forward to find all valid numbers s[start ~ end].
            for (int end = start; end < m; ++end) {
                String currNumber = s.substring(start, end + 1);
                
                if (Long.parseLong(currNumber) > k)
                    break;
                
                // If s[start ~ end] is valid, increment dp[(end + 1) % (n + 1)] by dp[start].
                dp[(end + 1) % (n + 1)] = (dp[(end + 1) % (n + 1)] + dp[start % (n + 1)]) % mod;
            }

            // Set dp[start % (n + 1)] as 0.
            dp[start % (n + 1)] = 0;
        }
        return dp[m % (n + 1)];
    }
}