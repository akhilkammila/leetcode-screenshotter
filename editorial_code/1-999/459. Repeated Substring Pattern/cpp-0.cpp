class Solution {
public:
    bool repeatedSubstringPattern(string s) {
        int n = s.length();
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                string pattern = "";
                for (int j = 0; j < n / i; j++) {
                    pattern += s.substr(0, i);
                }
                if (s == pattern) {
                    return true;
                }
            }
        }
        return false;
    }
};