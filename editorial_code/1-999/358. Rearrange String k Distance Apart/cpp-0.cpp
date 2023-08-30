class Solution {
public:
    string rearrangeString(string s, int k) {
        int freq[26] = {0};
        // Store the frequency for each character.
        for (int i = 0; i < s.size(); i++) {
            freq[s[i] - 'a']++;
        }
        
        priority_queue<pair<int, int>> free;
        // Insert the characters with their frequencies in the max heap.
        for (int i = 0; i < 26; i++) {
            if (freq[i]) {
                free.push({freq[i], i});
            }
        }
        
        string ans;
        // This queue stores the characters that cannot be used now.
        queue<pair<int, int>>  busy;
        while (ans.size() != s.size()) {
            int index = ans.size();
            
            // Insert the character that could be used now into the free heap.
            if (!busy.empty() && (index - busy.front().first) >= k) {
                auto q = busy.front(); busy.pop();
                free.push({freq[q.second], q.second});
            }
            
            // If the free heap is empty, it implies no character can be used at this index.
            if (free.empty()) {
                return "";
            }
            
            int currChar = free.top().second; free.pop();
            ans += currChar + 'a';
            
            // Insert the used character into busy queue with the current index.
            freq[currChar]--;
            if (freq[currChar] > 0) {
                busy.push({index, currChar});
            }
        }
        
        return ans;
    }
};