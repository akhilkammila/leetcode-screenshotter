public class Solution {
    public int[] findErrorNums(int[] nums) {
        int xor = 0, xor0 = 0, xor1 = 0;
        for (int n: nums)
            xor ^= n;
        for (int i = 1; i <= nums.length; i++)
            xor ^= i;
        int rightmostbit = xor & ~(xor - 1);
        for (int n: nums) {
            if ((n & rightmostbit) != 0)
                xor1 ^= n;
            else
                xor0 ^= n;
        }
        for (int i = 1; i <= nums.length; i++) {
            if ((i & rightmostbit) != 0)
                xor1 ^= i;
            else
                xor0 ^= i;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == xor0)
                return new int[]{xor0, xor1};
        }
        return new int[]{xor1, xor0};
    }
}