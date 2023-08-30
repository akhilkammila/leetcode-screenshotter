class Solution {
public:
    // Returns the elements in the first arg nums1 that don't exist in the second arg nums2.
    vector<int> getElementsOnlyInFirstList(vector<int>& nums1, vector<int>& nums2) {
        unordered_set<int> onlyInNums1;
        
        // Store nums2 elements in an unordered set. 
        unordered_set<int> existsInNums2;
        for (int num : nums2) {
            existsInNums2.insert(num);
        }
        
        // Iterate over each element in the list nums1.
        for (int num : nums1) {
            if (existsInNums2.find(num) == existsInNums2.end()) {
                onlyInNums1.insert(num);
            }
        }
        
        // Convert to vector.
        return vector<int> (onlyInNums1.begin(), onlyInNums1.end());
    }
    
    vector<vector<int>> findDifference(vector<int>& nums1, vector<int>& nums2) {
        return {getElementsOnlyInFirstList(nums1, nums2), getElementsOnlyInFirstList(nums2, nums1)};
    }
};