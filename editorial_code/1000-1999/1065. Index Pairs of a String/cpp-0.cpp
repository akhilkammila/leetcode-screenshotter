class Solution {
public:
    vector<vector<int>> indexPairs(string text, vector<string>& words) {
        unordered_set<string> wordsSet(words.begin(), words.end());
        vector<vector<int>> ans;
        for (int i = 0; i < text.size(); i++) {
            for (int j = i; j < text.size(); j++) {
                if (wordsSet.count(text.substr(i, j - i + 1))) {
                    ans.push_back({i, j});
                }
            }
        }
        return ans;
    }
};