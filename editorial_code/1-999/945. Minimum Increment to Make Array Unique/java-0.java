class Solution {
    public int minIncrementForUnique(int[] nums) {
        int maxVal = 0;
        for (int x : nums) {
            maxVal = Math.max(maxVal, x);
        }
        
        int[] count = new int[nums.length + maxVal];
        for (int x : nums) {
            count[x]++;
        }

        int moves = 0;
        int taken = 0;
        for (int x = 0; x < nums.length + maxVal; ++x) {
            if (count[x] >= 2) {
                taken += count[x] - 1;
                moves -= x * (count[x] - 1);
            } else if (taken > 0 && count[x] == 0) {
                taken--;
                moves += x;
            }
        }

        return moves;
    }
}