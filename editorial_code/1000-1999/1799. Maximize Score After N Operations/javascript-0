let backtrack = (nums, mask, pairsPicked, memo) => {
    // If we have picked all the numbers from 'nums' array, we can't get more score.
    if (2 * pairsPicked == nums.length) {
        return 0;
    }

    // If we already solved this sub-problem then return the stored result.
    if (memo[mask] != -1) {
        return memo[mask];
    }

    let maxScore = 0;

    // Iterate on 'nums' array to pick the first and second number of the pair.
    for (let firstIndex = 0; firstIndex < nums.length; ++firstIndex) {
        for (let secondIndex = firstIndex + 1; secondIndex < nums.length; ++secondIndex) {

            // If the numbers are same, or already picked, then we move to next number.
            if (((mask >> firstIndex) & 1) === 1 || ((mask >> secondIndex) & 1) === 1) {
                continue;
            }

            // Both numbers are marked as picked in this new mask.
            const newMask = mask | (1 << firstIndex) | (1 << secondIndex);

            // Calculate score of current pair of numbers, and the remaining array.
            const currScore = (pairsPicked + 1) * gcd(nums[firstIndex], nums[secondIndex]);
            const remainingScore = backtrack(nums, newMask, pairsPicked + 1, memo);

            // Store the maximum score.
            maxScore = Math.max(maxScore, currScore + remainingScore);
            // We will use old mask in loop's next interation, 
            // means we discarded the picked number and backtracked.
        }
    }

    // Store the result of the current sub-problem.
    memo[mask] = maxScore;
    return maxScore;
}

let maxScore = function(nums) {
    const memoSize = 1 << nums.length; // 2^(nums array size)
    const memo = new Array(memoSize).fill(-1);
    return backtrack(nums, 0, 0, memo);
};

// Utility function to calculate the gcd of two numbers.
let gcd = (a, b) => {
  return b === 0 ? a : gcd(b, a % b);
}