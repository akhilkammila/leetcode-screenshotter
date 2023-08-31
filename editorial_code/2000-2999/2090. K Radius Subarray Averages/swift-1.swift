class Solution {
    func getAverages(_ nums: [Int], _ k: Int) -> [Int] {
        // When a single element is considered then its average will be the number itself only.
        guard k > 0 else {
            return nums
        }

        let n = nums.count
        var averages = Array(repeating: -1, count: n)

        // Any index will not have 'k' elements in its left and right.
        if 2 * k + 1 > n {
            return averages
        }

        // First get the sum of first window of the 'nums' array.
        var windowSum = 0
        for i in 0..<(2 * k + 1) {
            windowSum += nums[i]
        }
        averages[k] = Int(windowSum / (2 * k + 1))

        // Iterate on rest indices which have at least 'k' elements
        // on its left and right sides.
        for i in (2 * k + 1)..<n {
            // We remove the discarded element and add the new element to get current window sum.
            // 'i' is the index of new inserted element, and
            // 'i - (window size)' is the index of the last removed element.
            windowSum = windowSum - nums[i - 2 * k - 1] + nums[i]
            averages[i - k] = Int(windowSum / (2 * k + 1))
        }

        return averages
    }
}