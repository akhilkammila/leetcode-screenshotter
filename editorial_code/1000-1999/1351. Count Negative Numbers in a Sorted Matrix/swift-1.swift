class Solution {
    func countNegatives(_ grid: [[Int]]) -> Int {
        var count = 0
        let n = grid[0].count
        // Iterate on all rows of the matrix one by one.
        for row in grid {
            // Using binary search find the index
            // which has the first negative element.
            var left = 0, right = n - 1
            while left <= right {
                let mid = (right + left) / 2
                if row[mid] < 0 {
                    right = mid - 1
                } else {
                    left = mid + 1
                }
            }
            // 'left' points to the first negative element,
            // which means 'n - left' is the number of all negative elements.
            count += (n - left)
        }
        return count
    }
}