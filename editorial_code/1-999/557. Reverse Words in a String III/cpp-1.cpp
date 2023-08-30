class Solution {
public:
    string reverseWords(string s) {
        int lastSpaceIndex = -1;
        int len = (int)s.size();
        for (int strIndex = 0; strIndex <= len; strIndex++) {
            if (strIndex == len || s[strIndex] == ' ') {
                int startIndex = lastSpaceIndex + 1;
                int endIndex = strIndex - 1;
                while (startIndex < endIndex) {
                    char temp = s[startIndex];
                    s[startIndex] = s[endIndex];
                    s[endIndex] = temp;
                    startIndex++;
                    endIndex--;
                }
                lastSpaceIndex = strIndex;
            }
        }
        return s;
    };
};