class Solution {
    public boolean validPartition(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        // Determine if the prefix array nums[0 ~ i] has a valid partition
        for (int i = 0; i < n; i++) {
            int dpIndex = i + 1;

            // Check 3 possibilities
            if (i > 0 && nums[i] == nums[i - 1]) {
                dp[dpIndex] |= dp[dpIndex - 2];
            }
            if (i > 1 && nums[i] == nums[i - 1] && nums[i] == nums[i - 2]) {
                dp[dpIndex] |= dp[dpIndex - 3];
            }
            if (i > 1 && nums[i] == nums[i - 1] + 1 && nums[i] == nums[i - 2] + 2) {
                dp[dpIndex] |= dp[dpIndex - 3];
            }
        }

        return dp[n];
    }
}