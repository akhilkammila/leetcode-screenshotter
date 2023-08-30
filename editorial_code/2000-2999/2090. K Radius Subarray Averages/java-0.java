class Solution {
    public int[] getAverages(int[] nums, int k) {
        // When a single element is considered then its averafge will be the number itself only.
        if (k == 0) {
            return nums;
        }

        int n = nums.length;
        int[] averages = new int[n];
        Arrays.fill(averages, -1);

        // Any index will not have 'k' elements in it's left and right.
        if (2 * k + 1 > n) {
            return averages;
        }

        // Generate 'prefix' array for 'nums'.
        // 'prefix[i + 1]' will be sum of all elements of 'nums' from index '0' to 'i'.
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; ++i) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        // We iterate only on those indices which have atleast 'k' elements in their left and right.
        // i.e. indices from 'k' to 'n - k'
        for (int i = k; i < (n - k); ++i) {
            int leftBound = i - k, rightBound = i + k;
            long subArraySum = prefix[rightBound + 1] - prefix[leftBound];
            int average = (int) (subArraySum / (2 * k + 1));
            averages[i] = average;
        }

        return averages;
    }
}