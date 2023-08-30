class Solution {
public:
    int numWays(vector<string>& words, string target) {
        const int ALPHABET_SIZE = 26;
        const int MOD = 1000000007;
        int targetLength = target.size(), wordLength = words[0].size();
        vector<vector<int>> charOccurrences(ALPHABET_SIZE, vector<int>(wordLength));
        for (int col = 0; col < wordLength; col++) {
            for (const string& word : words) {
                charOccurrences[word[col] - 'a'][col]++;
            }
        }
        
        function<long long(int, int)> calculateDP = [&](int length, int col) -> long long {
            if (col == 0) {
                return length == 0 ? 1 : 0;
            }
            long long result = calculateDP(length, col - 1);
            if (length > 0) {
                result += charOccurrences[target[length - 1] - 'a'][col - 1] * calculateDP(length - 1, col - 1);
            }
            result %= MOD;
            return result;
        };
        
        return calculateDP(targetLength, wordLength);
    }
};