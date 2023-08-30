class Solution {
public:
    int shortestWordDistance(vector<string>& wordsDict, string word1, string word2) {
        vector<int> indices1, indices2;
        // Store the indices of word1 in the list indices1 and indices of word2 in the list indices2.
        for (int i = 0; i < wordsDict.size(); i++) {
            if (wordsDict[i] == word1) {
                indices1.push_back(i);
            }
            if (wordsDict[i] == word2) {
                indices2.push_back(i);
            }
        }

        // Initialize it to maximum integer as it will store the minimum distance.
        int shortestDistance = INT_MAX;
        // Iterate over the indices of word1
        for (int index : indices1) {
            // Find the next greater index in the list indices2
            int x = upper_bound(indices2.begin(), indices2.end(), index) - indices2.begin();
                         
            if (x != indices2.size()) {
                // If x is not pointing to the last iterator, find the difference between these two indices
                shortestDistance = min(shortestDistance, indices2[x] - index);
            }
            
            if (x != 0 && indices2[x - 1] != index) {
                // Find difference betwee index and indices[x - 1], if x > 0 and the indices are not the same.
                shortestDistance = min(shortestDistance, index - indices2[x - 1]);
            }
        }
        
        return shortestDistance;
    }
};