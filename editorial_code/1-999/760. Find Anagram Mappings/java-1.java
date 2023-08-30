class Solution {
  public int[] anagramMappings(int[] nums1, int[] nums2) {
    // Store the index corresponding to the value in the second list.
    HashMap<Integer,Integer> valueToPos = new HashMap<>();
    for (int i = 0; i < nums2.length; i++) {
      valueToPos.put(nums2[i], i);
    }

    // List to store the anagram mappings.
    int[] mappings = new int[nums1.length];
    for (int i = 0; i < nums1.length; i++) {
      mappings[i]  = valueToPos.get(nums1[i]);
    }

    return mappings;
  }
}