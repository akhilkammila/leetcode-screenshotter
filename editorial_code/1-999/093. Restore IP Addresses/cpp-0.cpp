class Solution {
    bool valid(const string& s, int start, int length) {
        return length == 1 || (s[start] != '0' && (length < 3 || s.substr(start, length) <= "255"));
    }

    void helper(const string& s, int startIndex, vector<int>& dots, vector<string>& ans) {
        const int remainingLength = s.length() - startIndex;
        const int remainingNumberOfIntegers = 4 - dots.size();

        if (remainingLength > remainingNumberOfIntegers * 3 ||
            remainingLength < remainingNumberOfIntegers) {
            return;
        }
        if (dots.size() == 3) {
            if (valid(s, startIndex, remainingLength)) {
                string temp;
                int last = 0;
                for (int dot : dots) {
                    temp.append(s.substr(last, dot));
                    last += dot;
                    temp.append(".");
                }
                temp.append(s.substr(startIndex));
                ans.push_back(temp);
            }
            return;
        }
        for (int curPos = 1; curPos <= 3 && curPos <= remainingLength; ++curPos) {
            // Append a dot at the current position.
            dots.push_back(curPos);
            // Try making all combinations with the remaining string.
            if (valid(s, startIndex, curPos)) {
                helper(s, startIndex + curPos, dots, ans);
            }
            // Backtrack, i.e. remove the dot to try placing it at the next position.
            dots.pop_back();
        }
    }

public:
    vector<string> restoreIpAddresses(string s) {
        vector<int> dots;
        vector<string> ans;
        helper(s, 0, dots, ans);
        return ans;
    }
};