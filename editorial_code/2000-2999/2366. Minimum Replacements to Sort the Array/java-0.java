class Solution {
    public long minimumReplacement(int[] nums) {
        long answer = 0;
        int n = nums.length;

        // Start from the second last element, as the last one is always sorted.
        for (int i = n - 2; i >= 0; i--) {
            // No need to break if they are already in order.
            if (nums[i] <= nums[i + 1]) {
                continue;
            }

            // Count how many elements are made from breaking nums[i].
            long numElements = (long)(nums[i] + nums[i + 1] - 1) / (long)nums[i + 1];

            // It requires numElements - 1 replacement operations.
            answer += numElements - 1;

            // Maximize nums[i] after replacement.
            nums[i] = nums[i] / (int)numElements;
        }

        return answer;
    }
}