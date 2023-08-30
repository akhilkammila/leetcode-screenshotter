class Solution {
public:
    bool buddyStrings(string s, string goal) {
        if (s.size() != goal.size()) {
            return false;
        }

        if (s == goal) {
            // If we have 2 same characters in string 's',
            // we can swap them and still strings will remain equal.
            vector<int> frequency(26, 0);
            for (auto& ch : s) {
                frequency[ch - 'a'] += 1;
                if (frequency[ch - 'a'] == 2) {
                    return true;
                }
            }
            // Otherwise, if we swap any two characters it will make strings unequal.
            return false;
        }
        
        int firstIndex = -1;
        int secondIndex = -1;

        for (int i = 0; i < s.size(); ++i) {
            if (s[i] != goal[i]) {
                if (firstIndex == -1) {
                    firstIndex = i;
                } else if (secondIndex == -1) {
                    secondIndex = i;
                } else {
                    // We have at least 3 indices with different characters,
                    // thus, we can never make strings equal with only one swap.
                    return false;
                }
            }
        }

        if (secondIndex == -1) {
            // We can't swap if character at only one index is different.
            return false;
        }
        
        // All characters of both the string are same except two indices.
        return s[firstIndex] == goal[secondIndex] && 
               s[secondIndex] == goal[firstIndex];
    }
};