class Solution {
public:
    int shortestWordDistance(vector<string>& wordsDict, string word1, string word2) {
        // Initialize it to maximum integer as it will store the minimum distance.
        int shortestDistance = INT_MAX;
        
        // Initialize it to -1 as it's not pointing to any index yet.
        int prevIndex = -1;
        for (int i = 0; i < wordsDict.size(); i++) {
            // If the string at this index is either word1 or word2
            if (wordsDict[i] == word1 || wordsDict[i] == word2) {
                // If prevIndex is present and pointing to a different string than the string at the current index
                // Or if both word1 and word2 are the same.
                if (prevIndex != -1 && (wordsDict[prevIndex] != wordsDict[i] || word1 == word2)) {
                    shortestDistance = min(shortestDistance, i - prevIndex);
                }
                // Update the prevIndex to point it to the current index.
                prevIndex = i;
            }
        }  
        return shortestDistance;
    }
}; 