class Solution {
public:
    string reverseWords(string s) {
        string result;
        int lastSpaceIndex = -1;
        for (int strIndex = 0; strIndex < s.length(); strIndex++) {
            if ((strIndex == s.length() - 1) || s[strIndex] == ' ') {
                int reverseStrIndex =
                    (strIndex == s.length() - 1) ? strIndex : strIndex - 1;
                for (; reverseStrIndex > lastSpaceIndex; reverseStrIndex--) {
                    result += s[reverseStrIndex];
                }
                if (strIndex != s.length() - 1) {
                    result += ' ';
                }
                lastSpaceIndex = strIndex;
            }
        }
        return result;
    }
};