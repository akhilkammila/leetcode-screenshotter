class Solution {
public:
    vector<int> anagramMappings(vector<int>& nums1, vector<int>& nums2) {
        // Store the index corresponding to the value in the second list.
        unordered_map<int, int> valueToPos;
        for (int i = 0; i < nums2.size(); i++) {
            valueToPos[nums2[i]] = i;
        }
        
        // List to store the anagram mappings.
        vector<int> mappings;
        for (int num : nums1) {
            mappings.push_back(valueToPos[num]);
        }
        
        return mappings;
    }
};