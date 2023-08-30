class Solution {
public:
    int longestPalindrome(vector<string>& words) {
        constexpr int alphabetSize = 26;
        vector count(alphabetSize, vector<int>(alphabetSize));
        for (const string& word : words) {
            count[word[0] - 'a'][word[1] - 'a']++;
        }
        int answer = 0;
        bool central = false;
        for (int i = 0; i < alphabetSize; i++) {
            if (count[i][i] % 2 == 0) {
                answer += count[i][i];
            } else {
                answer += count[i][i] - 1;
                central = true;
            }
            for (int j = i + 1; j < alphabetSize; j++) {
                answer += 2 * min(count[i][j], count[j][i]);
            }
        }
        if (central) {
            answer++;
        }
        return 2 * answer;
    }
};