class Solution {
public:
    int storeFirstOptions(string& s, int startPos, vector<char>& firstOptions) {
        // If the first character is not '{', it means a single character
        if (s[startPos] != '{') {
            firstOptions.push_back(s[startPos]);
        } else {
            // Store all the characters between '{' and '}'
            while (s[startPos] != '}') {
                 if (s[startPos] >= 'a' && s[startPos] <= 'z') {
                     firstOptions.push_back(s[startPos]);
                 }
                startPos++;
            }
            // Sort the list
            sort(firstOptions.begin(), firstOptions.end());
        }
        // Increment it to point to the next character to be considered
        return startPos + 1;
    }
    
    vector<string> findAllWords(string& s, int startPos) {
        // Return empty string list if the string is empty
        if (startPos == s.size()) {
            return {""};
        }
        
        vector<char> firstOptions;
        // Store the characters for the first index as string in firstOptions
        int remStringStartPos = storeFirstOptions(s, startPos, firstOptions);
        vector<string> wordsWithRemString = findAllWords(s, remStringStartPos);
        
        vector<string> expandedWords;
        // Create new words by adding the character at the beginning
        for (char c : firstOptions) {
            for (string word : wordsWithRemString) {
                expandedWords.push_back(c + word);
            }
        }
        return expandedWords;
    }
    
    vector<string> expand(string s) {
        return findAllWords(s, 0);
    }
};