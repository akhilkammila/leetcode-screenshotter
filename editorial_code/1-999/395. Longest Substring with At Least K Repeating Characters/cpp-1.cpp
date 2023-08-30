class Solution {
    public:
    int longestSubstring(string s, int k) {
        int n = s.size();
        return longestSubstringUtil(s, 0, n, k);
    }
    int longestSubstringUtil(string &s, int start, int end, int k) {
        if (end < k) return 0;
        int countMap[26] = {0};
        // update the countMap with the count of each character
        for (int i = start; i < end; i++)
            countMap[s[i] - 'a']++;
        for (int mid = start; mid < end; mid++) {
            if (countMap[s[mid] - 'a'] >= k) continue;
            int midNext = mid + 1;
            while (midNext < end && countMap[s[midNext] - 'a'] < k) midNext++;
            return max(longestSubstringUtil(s, start, mid, k),
                    longestSubstringUtil(s, midNext, end, k));
        }
        return (end - start);
    }
};

