class Solution {
    func backtrack(_ nums: [Int], _ mask: Int, _ pairsPicked: Int, _ memo: inout [Int]) -> Int {
        // If we have picked all the numbers from 'nums' array, we can't get more score.
        if 2 * pairsPicked == nums.count {
            return 0
        }

        // If we already solved this sub-problem then return the stored result.
        if memo[mask] != -1 {
            return memo[mask]
        }

        var maxScore = 0

        // Iterate on 'nums' array to pick the first and second number of the pair.
        for firstIndex in 0..<nums.count {
            for secondIndex in (firstIndex + 1)..<nums.count {

                // If the numbers are same, or already picked, then we move to next number.
                guard ((mask >> firstIndex) & 1 == 0), ((mask >> secondIndex) & 1 == 0) else {
                    continue
                }

                // Both numbers are marked as picked in this new mask.
                let newMask = mask | (1 << firstIndex) | (1 << secondIndex)

                // Calculate score of current pair of numbers, and the remaining array.
                let currScore = (pairsPicked + 1) * gcd(nums[firstIndex], nums[secondIndex])
                let remainingScore = backtrack(nums, newMask, pairsPicked + 1, &memo)

                // Store the maximum score.
                maxScore = max(maxScore, currScore + remainingScore)
                // We will use old mask in loop's next interation, 
                // means we discarded the picked number and backtracked.
            }
        }

        // Store the result of the current sub-problem.
        memo[mask] = maxScore
        return maxScore
    }

    func maxScore(_ nums: [Int]) -> Int {
        let memoSize = 1 << nums.count // 2^(nums array size)
        var memo = Array(repeating: -1, count: memoSize)
        return backtrack(nums, 0, 0, &memo)
    }

    // Utility function to calculate the gcd of two numbers.
    func gcd(_ a: Int, _ b: Int) -> Int {
        return b == 0 ? a: gcd(b, a % b)
    }
}