class Solution {
public:
    bool arrayStringsAreEqual(vector<string>& word1, vector<string>& word2) {
        // Creates a new string by combining all the strings in word1.
        string word1Combined;
        for (string s : word1) {
            word1Combined += s;
        }
        // Creates a new string by combining all the strings in word2.
        string word2Combined;
        for (string s : word2) {
            word2Combined += s;
        }
        // Returns true if both string are the same.
        return word1Combined == word2Combined;
    }
};