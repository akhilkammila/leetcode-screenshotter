class Solution {
    func maxScore(_ nums: [Int]) -> Int {
        let maxStates = 1 << nums.count // 2^(nums array size)
        let finalMask = maxStates - 1
       
        // 'dp[i]' stores max score we can get after picking remaining numbers represented by 'i'.
        var dp = [Int](repeating: 0, count: maxStates)
       
        // Iterate on all possible states one-by-one.
        for state in (0...finalMask).reversed() {
            // If we have picked all numbers, we know we can't get more score as no number is remaining.
            guard state != finalMask else {
                dp[state] = 0
                continue
            }
           
            let numbersTaken = state.nonzeroBitCount
            let pairsFormed = numbersTaken / 2
            // States representing even numbers are taken are only valid.
            guard numbersTaken % 2 == 0 else {
                continue
            }
           
            // We have picked 'pairsFormed' pairs, we try all combinations of one more pair now.
            // We itearte on two numbers using two nested for loops.
            for firstIndex in 0..<nums.count {
                for secondIndex in (firstIndex + 1)..<nums.count {
                    // We only choose those numbers which were not already picked.
                    guard ((state >> firstIndex) & 1 == 0), ((state >> secondIndex) & 1 == 0) else {
                        continue
                    }
                    let currentScore = (pairsFormed + 1) * gcd(nums[firstIndex], nums[secondIndex])
                    let stateAfterPickingCurrPair = state | (1 << firstIndex) | (1 << secondIndex)
                    let remainingScore = dp[stateAfterPickingCurrPair]
                    dp[state] = max(dp[state], currentScore + remainingScore)
                }
            }
        }
       
        // Returning score we get from 'n' remaining numbers of array.
        return dp[0]
    }

    // Helper function to calculate gcd of two numbers
    func gcd(_ a: Int, _ b: Int) -> Int {
        if b == 0 {
            return a
        }
        return gcd(b, a % b)
    }
}