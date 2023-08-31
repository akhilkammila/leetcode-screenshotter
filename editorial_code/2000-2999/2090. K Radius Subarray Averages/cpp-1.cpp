class Solution {
public:
    vector<int> getAverages(vector<int>& nums, int k) {
        // When a single element is considered then its averafge will be the number itself only.
        if (k == 0) {
            return nums;
        }

        int n = nums.size();
        vector<int> averages(n, -1);

        // Any index will not have 'k' elements in it's left and right.
        if (2 * k + 1 > n) {
            return averages;
        }

        // First get the sum of first window of the 'nums' arrray.
        long long windowSum = 0;
        for (int i = 0; i < (2 * k + 1); ++i) {
            windowSum += nums[i];
        }
        averages[k] = windowSum / (2 * k + 1);

        // Iterate on rest indices which have atlest 'k' elements 
        // on its left and right sides.
        for (int i = (2 * k + 1); i < n; ++i) {
            // We remove the discarded element and add the new element to get current window sum.
            // 'i' is the index of new inserted element, and
            // 'i - (window size)' is the index of the last removed element.
            windowSum = windowSum - nums[i - (2 * k + 1)] + nums[i];
            averages[i - k] = windowSum / (2 * k + 1);
        }

        return averages;
    }
};