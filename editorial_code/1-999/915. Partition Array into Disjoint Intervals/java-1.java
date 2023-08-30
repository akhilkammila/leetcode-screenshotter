class Solution {
    public int partitionDisjoint(int[] nums) {
        int N = nums.length;
        int[] minRight = new int[N];
        minRight[N - 1] = nums[N - 1];

        for (int i = N - 2; i >= 0; --i) {
            minRight[i] = Math.min(minRight[i + 1], nums[i]);
        }

        int currMax = nums[0];
        for (int i = 1; i < N; ++i) {
            currMax = Math.max(currMax, nums[i - 1]);
            if (currMax <= minRight[i]) {
                return i;
            }
        }
        // In case there is no solution, we'll return -1
        return -1;
    }
}