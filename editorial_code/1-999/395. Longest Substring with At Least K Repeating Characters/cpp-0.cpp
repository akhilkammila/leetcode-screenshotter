class Solution {
public:
    int longestSubstring(string s, int k) {
        if (s.size() == 0 || k > s.length()) {
            return 0;
        }
        int countMap[26] = {0};
        int n = s.length();
        int result = 0;
        for (int start = 0; start < n; start++) {
            // reset the count map
            memset(countMap, 0, sizeof(countMap));
            for (int end = start; end < n; end++) {
                countMap[s[end] - 'a']++;
                if (isValid(s, start, end, k, countMap)) {
                    result = max(result, end - start + 1);
                }
            }
        }
        return result;
    }

    bool isValid(string s, int start, int end, int k, int countMap[26]) {
        int countLetters = 0, countAtLeastK = 0;
        for (int i = 0; i < 26; i++) {
            if (countMap[i] > 0) countLetters++;
            if (countMap[i] >= k) countAtLeastK++;
        }
        return countAtLeastK == countLetters;
    }

};

