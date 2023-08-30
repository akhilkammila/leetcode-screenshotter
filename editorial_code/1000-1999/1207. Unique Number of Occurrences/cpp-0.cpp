class Solution {
public:
    // Constant to make elements non-negative.
    static constexpr int K = 1000;
    
    bool uniqueOccurrences(vector<int>& arr) {
        vector<int> freq(2 * K  + 1);
    
        // Store the frequency of elements in the unordered map.
        for (int num : arr) {
            freq[num + K]++;
        }
        
        // Sort the frequency count.
        sort(freq.begin(), freq.end());
        
        // If the adjacent freq count is equal, then the freq count isn't unique.
        for (int i = 0; i < 2 * K; i++) {
            if (freq[i] && freq[i] == freq[i + 1]) {
                return false;
            }
        }
        
        // If all the elements are traversed, it implies frequency counts are unique.
        return true;
    }
};