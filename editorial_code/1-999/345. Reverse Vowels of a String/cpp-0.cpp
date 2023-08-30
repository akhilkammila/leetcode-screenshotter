class Solution {
public:
    // Return true if the character is a vowel (case-insensitive)
    bool isVowel(char c) {
        return c == 'a' || c == 'i' || c == 'e' || c == 'o' || c == 'u'
            || c == 'A' || c == 'I' || c == 'E' || c == 'O' || c == 'U';
    }
    
    string reverseVowels(string s) {
        int start = 0;
        int end  = s.size() - 1;
        
        // While we still have characters to traverse
        while (start < end) {
            // Find the leftmost vowel
            while (start < s.size() && !isVowel(s[start])) {
                start++;
            }
            // Find the rightmost vowel
            while (end >= 0 && !isVowel(s[end])) {
                end--;
            }
            // Swap them if start is left of end
            if (start < end) {
                swap(s[start++], s[end--]);
            }
        }
        
        return s;
    }
};