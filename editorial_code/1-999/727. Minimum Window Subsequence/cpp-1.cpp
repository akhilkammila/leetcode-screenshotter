class Solution {
public:
    string minWindow(string s1, string s2) {
        int n = s1.size(), m = s2.size();
        vector<int> f(m + 1, 1000000000), g(m + 1);
        f[0] = 0;
        int end = 0, length = n + 1;
        for (int i = 1; i <= n; i++) {
            g[0] = 0;
            for (int j = 1; j <= m; j++) {
                g[j] = 1 + (s1[i - 1] == s2[j - 1] ? f[j - 1] : f[j]);
            }
            f = g;
            if (f[m] < length) {
                length = f[m];
                end = i;
            }
        }
        return length > n ? "" : s1.substr(end - length, length);
    }
};