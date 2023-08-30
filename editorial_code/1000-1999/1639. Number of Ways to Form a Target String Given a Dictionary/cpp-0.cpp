class Solution {
public:
    int numWays(vector<string>& words, string target) {
        const int ALPHABET_SIZE = 26;
        const int MOD = 1000000007;
        int targetLength = target.size();
        int wordLength = words[0].size();
        vector<vector<int>> charOccurrences(ALPHABET_SIZE, vector<int>(wordLength));
        
        for (int col = 0; col < wordLength; col++) {
            for (const string& word : words) {
                charOccurrences[word[col] - 'a'][col]++;
            }
        }
        
        vector<vector<long long>> dp(targetLength + 1, vector<long long>(wordLength + 1));
        dp[0][0] = 1;
        
        for (int length = 0; length <= targetLength; length++) {
            for (int col = 0; col < wordLength; col++) {
                if (length < targetLength) {
                    dp[length + 1][col + 1] = (dp[length + 1][col + 1] + 
                        (charOccurrences[target[length] - 'a'][col] * dp[length][col]) % MOD) % MOD;
                }
                dp[length][col + 1] = (dp[length][col + 1] + dp[length][col]) % MOD;
            }
        }
        
        return dp[targetLength][wordLength];
    }
};