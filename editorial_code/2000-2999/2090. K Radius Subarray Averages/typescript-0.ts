function getAverages(nums: number[], k: number): number[] {
    // When a single element is considered then its averafge will be the number itself only.
    if (k === 0) {
        return nums;
    }

    const n = nums.length;
    const averages = new Array(n).fill(-1);

    // Any index will not have 'k' elements in it's left and right.
    if (2 * k + 1 > n) {
        return averages;
    }

    // Generate 'prefix' array for 'nums'.
    // 'prefix[i + 1]' will be sum of all elements of 'nums' from index '0' to 'i'.
    const prefix: number[] = new Array(n + 1).fill(0);
    for (let i = 0; i < n; ++i) {
        prefix[i + 1] = prefix[i] + nums[i];
    }

    // We iterate only on those indices which have atleast 'k' elements in their left and right.
    // i.e. indices from 'k' to 'n - k'
    for (let i = k; i < n - k; ++i) {
        const leftBound = i - k, rightBound = i + k;
        const subArraySum = prefix[rightBound + 1] - prefix[leftBound];
        const average = Math.floor(subArraySum / (2 * k + 1));
        averages[i] = average;
    }

    return averages;
};