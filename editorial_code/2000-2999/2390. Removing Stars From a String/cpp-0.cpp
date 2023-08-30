class Solution {
public:
    string removeStars(string s) {
        stack<char> st;
        for (int i = 0; i < s.size(); i++) {
            if (s[i] == '*') {
                st.pop();
            } else {
                st.push(s[i]);
            }
        }

        string answer = "";
        while (!st.empty()) {
            answer.push_back(st.top());
            st.pop();
        }

        reverse(answer.begin(), answer.end());
        return answer;
    }
};