class Solution {
public:
    string removeStars(string s) {
        vector<char> ch(s.size());
        int j = 0;

        for (int i = 0; i < s.size(); i++) {
            if (s[i] == '*') {
                j--;
            } else {
                ch[j++] = s[i];
            }
        }

        string answer = "";
        for (int i = 0; i < j; i++) {
            answer.push_back(ch[i]);
        }

        return answer;
    }
};