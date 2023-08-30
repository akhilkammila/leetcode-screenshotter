class Solution {
public:
    int backtrack(vector<int>& nums, int mask, int pairsPicked, vector<int>& memo) {
        // If we have picked all the numbers from 'nums' array, we can't get more score.
        if (2 * pairsPicked == nums.size()) {
            return 0;
        }

        // If we already solved this sub-problem then return the stored result.
        if (memo[mask] != -1) {
            return memo[mask];
        }

        int maxScore = 0;

        // Iterate on 'nums' array to pick the first and second number of the pair.
        for (int firstIndex = 0; firstIndex < nums.size(); ++firstIndex) {
            for (int secondIndex = firstIndex + 1; secondIndex < nums.size(); ++secondIndex) {
    
                // If the numbers are same, or already picked, then we move to next number.
                if (((mask >> firstIndex) & 1) == 1 or ((mask >> secondIndex) & 1) == 1) {
                    continue;
                }

                // Both numbers are marked as picked in this new mask.
                int newMask = mask | (1 << firstIndex) | ((1 << secondIndex));

                // Calculate score of current pair of numbers, and the remaining array.
                int currScore = (pairsPicked + 1) * __gcd(nums[firstIndex], nums[secondIndex]);
                int remainingScore = backtrack(nums, newMask, pairsPicked + 1, memo);

                // Store the maximum score.
                maxScore = max(maxScore, currScore + remainingScore);
                // We will use old mask in loop's next interation, 
                // means we discarded the picked number and backtracked.
            }
        }

        // Store the result of the current sub-problem.
        memo[mask] = maxScore;
        return maxScore;
    }

    int maxScore(vector<int>& nums) {
        int memoSize = 1 << nums.size(); // 2^(nums array size)
        vector<int> memo(memoSize, -1);
        return backtrack(nums, 0, 0, memo);
    }
};