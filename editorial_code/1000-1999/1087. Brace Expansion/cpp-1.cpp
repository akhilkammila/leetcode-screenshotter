class Solution {
public:
    int storeFirstOptions(string& s, int startPos, vector<string>& firstOptions) {
        // If the first character is not '{', it means a single character
        if (s[startPos] != '{') {
            firstOptions.push_back(string(1, s[startPos]));
        } else {
            // Store all the characters between '{' and '}'
            while (s[startPos] != '}') {
                 if (s[startPos] >= 'a' && s[startPos] <= 'z') {
                     firstOptions.push_back(string(1, s[startPos]));
                 }
                startPos++;
            }
            // Sort the list
            sort(firstOptions.begin(), firstOptions.end());
        }
        // Increment it to point to the next character to be considered
        return startPos + 1;
    }
    
    vector<string> expand(string s) {
        vector<string> expandedWords = {""};
        
        int startPos = 0;
        while (startPos < s.size()) {
            vector<string> firstOptions;
            // Store the characters for the first index as string in firstOptions
            int remStringStartPos = storeFirstOptions(s, startPos, firstOptions);
            
            vector<string> currWords;
            // Append the string in the list firstOptions to string in expandedWords
            for (string word : expandedWords) {
                for (string c : firstOptions) {
                    currWords.push_back(word + c);
                }
            }
            // Update the list expandedWords to have all the words
            expandedWords = currWords;
            // Pointing to the next character to be considered
            startPos = remStringStartPos;
        }
        return expandedWords;
    }
};