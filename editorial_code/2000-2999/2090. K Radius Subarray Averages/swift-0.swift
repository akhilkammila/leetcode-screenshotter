class Solution {
    func getAverages(_ nums: [Int], _ k: Int) -> [Int] {
        // When a single element is considered then its averafge will be the number itself only.
        guard k != 0 else {
            return nums
        }

        let n = nums.count
        var averages = Array(repeating: -1, count: n)

        // Any index will not have 'k' elements in it's left and right.
        guard (2 * k + 1) <= n else {
            return averages
        }

        // Generate 'prefix' array for 'nums'.
        // 'prefix[i + 1]' will be sum of all elements of 'nums' from index '0' to 'i'.
        var prefix = Array(repeating: 0, count: n + 1)
        for i in 0..<n {
            prefix[i + 1] = prefix[i] + nums[i]
        }

        // We iterate only on those indices which have atleast 'k' elements in their left and right.
        // i.e. indices from 'k' to 'n - k'
        for i in k..<(n-k) {
            let leftBound = i - k, rightBound = i + k
            let subArraySum = prefix[rightBound + 1] - prefix[leftBound]
            let average = subArraySum / (2 * k + 1)
            averages[i] = average
        }

        return averages
    }
}