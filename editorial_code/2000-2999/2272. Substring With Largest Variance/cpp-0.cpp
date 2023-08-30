class Solution {
public:
    int largestVariance(string s) {
        vector<int> counter(26, 0);
        for (char ch : s) {
            counter[ch - 'a']++;
        }
        int globalMax = 0;
        
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                // major and minor cannot be the same, and both must appear in s.
                if (i == j || counter[i] == 0 || counter[j] == 0) {
                    continue;
                }
                
                // Find the maximum variance of major - minor.        
                char major = 'a' + i;
                char minor = 'a' + j;
                int majorCount = 0;
                int minorCount = 0;
                
                // The remaining minor in the rest of s.
                int restMinor = counter[j];
                
                for (char ch : s) {    
                    if (ch == major) {
                        majorCount++;
                    }
                    if (ch == minor) {
                        minorCount++;
                        restMinor--;
                    }
                    
                    // Only update the variance (local_max) if there is at least one minor.
                    if (minorCount > 0)
                        globalMax = max(globalMax, majorCount - minorCount);
                    
                    // We can discard the previous string if there is at least one remaining minor
                    if (majorCount < minorCount && restMinor > 0) {
                        majorCount = 0;
                        minorCount = 0;
                    }
                }
            }
        }
        
        return globalMax;
    }
};
