class Solution {
public:
    bool uniqueOccurrences(vector<int>& arr) {
        // Store the frequency of elements in the unordered map.
        unordered_map<int, int> freq;
        for (int num : arr) {
            freq[num]++;
        }
        
        // Store the frequency count of elements in the unordered set.
        unordered_set<int> freqSet;
        for (auto [key, value] : freq) {
            freqSet.insert(value);
        }
        
        // If the set size is equal to the map size, 
        // It implies frequency counts are unique.
        return freqSet.size() == freq.size();
    }
};