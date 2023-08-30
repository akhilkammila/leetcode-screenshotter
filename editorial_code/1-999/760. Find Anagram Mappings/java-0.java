class Solution {
    public int[] anagramMappings(int[] nums1, int[] nums2) {
        // List to store the anagram mappings.
        int[] mappings = new int[nums1.length];
        
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                // Store the corresponding index of number in the second list.
                if (nums1[i] == nums2[j]) {
                    mappings[i] = j;
                    break;
                }
            }
        }
        return mappings;
    }
}