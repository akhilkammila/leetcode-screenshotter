import java.util.Arrays;

class Solution {
    static final int ALPHABET_SIZE = 26;
    static final int MOD = 1000000007;
    int[][] charOccurrences;
    long[][] dp;

    long calculateDP(String target, int length, int col) {
        if (col == 0) {
            return length == 0 ? 1 : 0;
        }
        if (dp[length][col] != -1) {
            return dp[length][col];
        }
        dp[length][col] = calculateDP(target, length, col - 1);
        if (length > 0) {
            dp[length][col] += charOccurrences[target.charAt(length - 1) - 'a'][col - 1] * calculateDP(target, length - 1, col - 1);
        }
        dp[length][col] %= MOD;
        return dp[length][col];
    }
    
    public int numWays(String[] words, String target) {
        int targetLength = target.length(), wordLength = words[0].length();
        charOccurrences = new int[ALPHABET_SIZE][wordLength];
        for (int col = 0; col < wordLength; col++) {
            for (String word : words) {
                charOccurrences[word.charAt(col) - 'a'][col]++;
            }
        }
        dp = new long[targetLength + 1][wordLength + 1];
        for (int length = 0; length <= targetLength; length++) {
            Arrays.fill(dp[length], -1);
        }
        return (int) calculateDP(target, targetLength, wordLength);
    }
}