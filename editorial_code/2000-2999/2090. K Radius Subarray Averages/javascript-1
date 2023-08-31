var getAverages = function(nums, k) {
    // When a single element is considered then its average will be the number itself only.
    if (k === 0) {
        return nums;
    }

    const n = nums.length;
    const averages = new Array(n).fill(-1);

    // Any index will not have 'k' elements in its left and right.
    if (2 * k + 1 > n) {
        return averages;
    }

    // First get the sum of first window of the 'nums' array.
    let windowSum = 0;
    for (let i = 0; i < 2 * k + 1; ++i) {
        windowSum += nums[i];
    }
    averages[k] = Math.floor(windowSum / (2 * k + 1));

    // Iterate on rest indices which have at least 'k' elements 
    // on its left and right sides.
    for (let i = 2 * k + 1; i < n; ++i) {
        // We remove the discarded element and add the new element to get current window sum.
        // 'i' is the index of new inserted element, and
        // 'i - (window size)' is the index of the last removed element.
        windowSum = windowSum - nums[i - 2 * k - 1] + nums[i];
        averages[i - k] = Math.floor(windowSum / (2 * k + 1));
    }

    return averages;    
};