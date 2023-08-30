class Solution {
public:
    bool areSentencesSimilar(vector<string>& sentence1, vector<string>& sentence2,
                             vector<vector<string>>& similarPairs) {
        if (sentence1.size() != sentence2.size()) {
            return false;
        }
        unordered_map<string, unordered_set<string>> wordToSimilarWords;
        for (auto& pair : similarPairs) {
            wordToSimilarWords[pair[0]].insert(pair[1]);
            wordToSimilarWords[pair[1]].insert(pair[0]);
        }

        for (int i = 0; i < sentence1.size(); i++) {
            // If the words are equal, continue.
            if (sentence1[i] == sentence2[i]) {
                continue;
            }
            // If the words form a similar pair, continue.
            if (wordToSimilarWords[sentence1[i]].count(sentence2[i])) {
                continue;
            }
            return false;
        }

        return true;
    }
};