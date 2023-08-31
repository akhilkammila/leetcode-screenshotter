class Solution {
    func countNegatives(_ grid: [[Int]]) -> Int {
        var count = 0
        // Iterate on all elements of the matrix one by one.
        for row in grid {
            for element in row {
                // If the current element is negative, we count it.
                if element < 0 {
                    count += 1
                }
            }
        }
        return count
    }
}