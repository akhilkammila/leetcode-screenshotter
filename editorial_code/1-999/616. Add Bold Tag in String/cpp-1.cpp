class Solution {
public:
    string addBoldTag(string s, vector<string>& words) {
        int n = s.size();
        vector<bool> bold(n);
        
        for (string word: words) {
            int start = s.find(word);
            while (start != -1) {
                for (int i = start; i < start + word.size(); i++) {
                    bold[i] = true;
                }
                
                start = s.find(word, start + 1);
            }
        }
        
        string openTag = "<b>";
        string closeTag = "</b>";
        string ans = "";
        
        for (int i = 0; i < n; i++) {
            if (bold[i] && (i == 0 || !bold[i - 1])) {
                ans += openTag;
            }
            
            ans += s[i];
            
            if (bold[i] && (i == n - 1 || !bold[i + 1])) {
                ans += closeTag;
            }
        }
        
        return ans;
    }
};