class Solution {
    public boolean validPartition(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[3];
        dp[0] = true;

        // Determine if prefix array nums[0 ~ i] has a valid partition
        for (int i = 0; i < n; i++) {
            int dpIndex = i + 1;
            boolean ans = false;

            // Check 3 possibilities
            if (i > 0 && nums[i] == nums[i - 1]) {
                ans |= dp[(dpIndex - 2) % 3];
            }
            if (i > 1 && nums[i] == nums[i - 1] && nums[i] == nums[i - 2]) {
                ans |= dp[(dpIndex - 3) % 3];
            }
            if (i > 1 && nums[i] == nums[i - 1] + 1 && nums[i] == nums[i - 2] + 2) {
                ans |= dp[(dpIndex - 3) % 3];
            }

            dp[dpIndex % 3] = ans;
        }

        return dp[n % 3];
    }
}