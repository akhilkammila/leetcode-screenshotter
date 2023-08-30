class Solution {
public:
    string minWindow(string s1, string s2) {
        int n = s1.size(), m = s2.size();
        string answer;
        unordered_map<char, vector<int>> indices;
        for (int i = 0; i < n; i++) {
            indices[s1[i]].push_back(i);
        }
        vector<int> ind(m);
        for (int start = 0; start < n; start++) {
            int prev = start - 1;
            bool notFound = false;
            for (int j = 0; j < m; j++) {
                if (!indices.count(s2[j])) {
                    return "";
                }
                const vector<int>& curIndices = indices[s2[j]];
                while (ind[j] < curIndices.size() && curIndices[ind[j]] <= prev) {
                    ind[j]++;
                }
                if (ind[j] == curIndices.size()) {
                    return answer;
                }
                prev = curIndices[ind[j]];
            }
            if (answer == "" || prev - start + 1 < answer.size()) {
                answer = s1.substr(start, prev - start + 1);
            }
        }
        return answer;
    }
};