class Solution {
    public boolean xorGame(int[] nums) {
      int x = 0;
      for (int v : nums) x ^= v;
      return x == 0 || nums.length % 2 == 0;
    }
}