class Solution {
public:
    string licenseKeyFormatting(string s, int k) {
        int totalChars = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s[i] != '-') {
                totalChars++;
            }
        }
        int sizeOfFirstGroup = (totalChars % k);
        if (sizeOfFirstGroup == 0) {
            sizeOfFirstGroup = k;
        }
        string ans = "";
        int i = 0;
        int count = 0;
        
        while (i < s.length()) {
            if (count == sizeOfFirstGroup) {
                count = 0;
                break;
            }
            if (s[i] != '-') {
                count++;
                ans.push_back(toupper(s[i]));
            }
            i++;
        }
        /* This case will only appear if the value of k is greater than the total number 
           of alphanumeric characters in string s */
        if (i >= s.length()) {
            return ans;
        }
        
        ans.push_back('-');
        
        while (i < s.length()) {
            if (s[i] != '-') {
                /* Whenever count is equal to k, we put a '-' after each group*/
                if (count == k) {
                    ans.push_back('-');
                    count = 0;
                }
                ans.push_back(toupper(s[i]));
                count++;
            }
            i++;
        }
        return ans;
    }
};