class Solution {
    // Returns the elements in the first arg nums1 that don't exist in the second arg nums2.
    List<Integer> getElementsOnlyInFirstList(int[] nums1, int[] nums2) {
        Set<Integer> onlyInNums1 = new HashSet<> (); 
        
        // Store nums2 elements in an unordered set. 
        Set<Integer> existsInNums2 = new HashSet<> (); 
        for (int num : nums2) {
            existsInNums2.add(num);
        }
        
        // Iterate over each element in the list nums1.
        for (int num : nums1) {
            if (!existsInNums2.contains(num)) {
                onlyInNums1.add(num);
            }
        }
        
        // Convert to vector.
        return new ArrayList<>(onlyInNums1);
    }
    
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        return Arrays.asList(getElementsOnlyInFirstList(nums1, nums2), getElementsOnlyInFirstList(nums2, nums1));
    }
}