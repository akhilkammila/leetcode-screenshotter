class Solution {
  final int bitsToShift = 7;
  final int numToGetLastBits = (1 << bitsToShift) - 1;

  public int[] anagramMappings(int[] nums1, int[] nums2) {
    // Store the index within the integer itself.
    for (int i = 0; i < nums1.length; i++) {
      nums1[i] = (nums1[i] << bitsToShift) + i;
      nums2[i] = (nums2[i] << bitsToShift) + i;
    }

    // Sort both lists so that the original integers end up at the same index.
    Arrays.sort(nums1);
    Arrays.sort(nums2);

    // List to store the anagram mappings.
    int[] mappings = new int[nums1.length];
    for (int i = 0; i < nums1.length; i++) {
      // Store the index in the second list corresponding to the integer index in the first list.
      mappings[nums1[i] & numToGetLastBits] = (nums2[i] & numToGetLastBits);
    }

    return mappings;
  }
}