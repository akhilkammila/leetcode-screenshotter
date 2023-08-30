class Solution {
    public int numWays(String[] words, String target) {
        final int ALPHABET_SIZE = 26;
        final int MOD = 1_000_000_007;
        int targetLength = target.length();
        int wordLength = words[0].length();
        
        int[][] charOccurrences = new int[ALPHABET_SIZE][wordLength];
        for (int col = 0; col < wordLength; col++) {
            for (String word : words) {
                charOccurrences[word.charAt(col) - 'a'][col]++;
            }
        }
        
        long[][] dp = new long[targetLength + 1][wordLength + 1];
        dp[0][0] = 1;
        
        for (int length = 0; length <= targetLength; length++) {
            for (int col = 0; col < wordLength; col++) {
                if (length < targetLength) {
                    dp[length + 1][col + 1] += charOccurrences[target.charAt(length) - 'a'][col] * dp[length][col];
                    dp[length + 1][col + 1] %= MOD;
                }
                dp[length][col + 1] += dp[length][col];
                dp[length][col + 1] %= MOD;
            }
        }
        
        return (int) dp[targetLength][wordLength];
    }
}