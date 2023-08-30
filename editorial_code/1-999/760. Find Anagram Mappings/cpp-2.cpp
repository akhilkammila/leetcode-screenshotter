class Solution {
public:
    const int bitsToShift = 7;
    const int numToGetLastBits = (1 << bitsToShift) - 1;
    
    vector<int> anagramMappings(vector<int>& nums1, vector<int>& nums2) {
        // Store the index within the integer itself.
        for (int i = 0; i < nums1.size(); i++) {
            nums1[i] = (nums1[i] << bitsToShift) + i;
            nums2[i] = (nums2[i] << bitsToShift) + i;
        }
        
        // Sort both lists so that the original integers end up at the same index.
        sort(nums1.begin(), nums1.end());
        sort(nums2.begin(), nums2.end());
        
        // List to store the anagram mappings.
        vector<int> mappings(nums1.size());
        for (int i = 0; i < nums1.size(); i++) {
            // Store the index in the second list corresponding to the integer index in the first list.
            mappings[nums1[i] & numToGetLastBits] = (nums2[i] & numToGetLastBits);
        }

        return mappings;
    }
};