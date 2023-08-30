class Solution {
public:
    int shortestWordDistance(vector<string>& wordsDict, string word1, string word2) {
        vector<pair<int, int>> indices;
        // Store the indices of word1 or word2 and an extra integer in the pair
        // as 0 if the string is word1 or 1 if the string is word2.
        for (int i = 0; i < wordsDict.size(); i++) {
            if (wordsDict[i] == word1) {
                indices.push_back({i, 0});
            }
            if (wordsDict[i] == word2) {
                indices.push_back({i, 1});
            }
        }

        // Initialize it to maximum integer as it will store the minimum distance.
        int shortestDistance = INT_MAX;
        for (int i = 0; i < indices.size() - 1; i++) {
            // If the two consecutive pairs have both different values
            if (indices[i].second != indices[i + 1].second && indices[i].first != indices[i + 1].first) {
                // Find the difference between indices and update shortestDistance
                shortestDistance = min(shortestDistance, indices[i + 1].first - indices[i].first);
            }
        }
        return shortestDistance;
    }
};