class Solution {
public:
    vector<string> findAllConcatenatedWordsInADict(vector<string>& words) {
        unordered_set<string> dictionary(words.begin(), words.end());
        vector<string> answer;
        for (const string& word : words) {
            const int length = word.length();
            vector<bool> dp(length + 1);
            dp[0] = true;
            for (int i = 1; i <= length; ++i) {
                for (int j = (i == length ? 1 : 0); !dp[i] && j < i; ++j) {
                    dp[i] = dp[j] && dictionary.count(word.substr(j, i - j));
                }
            }
            if (dp[length]) {
                answer.push_back(word);
            }
        }
        return answer;
    }
};
