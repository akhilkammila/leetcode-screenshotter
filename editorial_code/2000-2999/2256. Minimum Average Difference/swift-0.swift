class Solution {
    func minimumAverageDifference(_ nums: [Int]) -> Int {
        let n = nums.count
        var ans = -1
        var minAvgDiff = Int32.max
        
        for index in 0..<n {
            // Calculate average of left part of array, index 0 to i.
            let leftPartAverage = nums[0...index].map{Int64($0)}.reduce(Int64(0), +) / Int64(index + 1)
            
            // Calculate average of right part of array, index i+1 to n-1.
            let rightPartAverage = nums[(index + 1)..<n].map{Int64($0)}.reduce(Int64(0), +)
            // If right part have 0 elements, then we don't divide by 0.
            if (index != n - 1) {
                rightPartAverage /= Int64(n - index - 1)
            }
            
            let currDifference = abs(leftPartAverage - rightPartAverage)
            // If current difference of averages is smaller,
            // then current index can be our answer.
            if (currDifference < minAvgDiff) {
                minAvgDiff = Int32(currDifference)
                ans = index
            }
        }
        
        return ans
    }
}