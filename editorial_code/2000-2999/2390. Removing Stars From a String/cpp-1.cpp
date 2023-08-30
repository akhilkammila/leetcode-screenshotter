class Solution {
public:
    string removeStars(string s) {
        string answer = "";
        for (int i = 0; i < s.size(); i++) {
            if (s[i] == '*') {
                answer.pop_back();
            } else {
                answer.push_back(s[i]);
            }
        }
        return answer;
    }
};