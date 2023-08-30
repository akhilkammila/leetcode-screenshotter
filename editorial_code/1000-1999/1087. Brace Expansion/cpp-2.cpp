class Solution {
public:
    vector<vector<char>> allOptions;
    
    void storeAllOptions(string& s) {
        for (int pos = 0; pos < s.size(); pos++) {
            vector<char> currOptions;
            
            // If the first character is not '{', it means a single character
            if (s[pos] != '{') {
                currOptions.push_back(s[pos]);
            } else {
                // Store all the characters between '{' and '}'
                while (s[pos] != '}') {
                    if (s[pos] >= 'a' && s[pos] <= 'z') {
                        currOptions.push_back(s[pos]);
                    }
                    pos++;
                }
                // Sort the list
                sort(currOptions.begin(), currOptions.end());
            }
            allOptions.push_back(currOptions);
        }
    }
    
    void generateWords(string currString, vector<string>& expandedWords) {
        // If the currString is complete, we can store and return
        if (currString.size() == allOptions.size()) {
            expandedWords.push_back(currString);
            return;
        }
        
        // Fetch the options for the current index
        vector<char> currOptions = allOptions[currString.size()];

        // Add the character and go into recursion
        for (char c : currOptions) {
            currString += c;
            generateWords(currString, expandedWords);
            // Backtrack to previous state
            currString.pop_back();
        }
    }
    
    vector<string> expand(string s) {
        // Store the character options for different indices
        storeAllOptions(s);
        
        vector<string> expandedWords;
        generateWords("", expandedWords);
        return expandedWords;
    }
};