class Solution {
public:
    bool checkIfPangram(string sentence) {
        // Add every letter of 'sentence' to hash set 'seen'.
        unordered_set<char> seen(sentence.begin(), sentence.end());
        
        // If the size of 'seen' is 26, then 'sentence' is a pangram.
        return seen.size() == 26;
    }
};