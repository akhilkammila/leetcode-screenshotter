class Solution {
public:
    int longestSubstring(string s, int k) {
        int countMap[26];
        int maxUnique = getMaxUniqueLetters(s);
        int result = 0;
        for (int currUnique = 1; currUnique <= maxUnique; currUnique++) {
            // reset countMap
            memset(countMap, 0, sizeof(countMap));
            int windowStart = 0, windowEnd = 0, idx = 0, unique = 0, countAtLeastK = 0;
            while (windowEnd < s.size()) {
                // expand the sliding window
                if (unique <= currUnique) {
                    idx = s[windowEnd] - 'a';
                    if (countMap[idx] == 0) unique++;
                    countMap[idx]++;
                    if (countMap[idx] == k) countAtLeastK++;
                    windowEnd++;
                }
                // shrink the sliding window
                else {
                    idx = s[windowStart] - 'a';
                    if (countMap[idx] == k) countAtLeastK--;
                    countMap[idx]--;
                    if (countMap[idx] == 0) unique--;
                    windowStart++;
                }
                if (unique == currUnique && unique == countAtLeastK)
                    result = max(windowEnd - windowStart, result);
            }
        }

        return result;
    }

    // get the maximum number of unique letters in the string s
    int getMaxUniqueLetters(string s) {
        bool map[26] = {0};
        int maxUnique = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!map[s[i] - 'a']) {
                maxUnique++;
                map[s[i] - 'a'] = true;
            }
        }
        return maxUnique;
    }
};
