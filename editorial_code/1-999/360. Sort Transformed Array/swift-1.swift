class Solution {
    private func transform(value x: Int, with a: Int, _ b: Int, _ c: Int) -> Int {
        // Return the transformed result for element 'x'
        return (a * x * x) + (b * x) + c
    }

    func sortTransformedArray(_ nums: [Int], _ a: Int, _ b: Int, _ c: Int) -> [Int] {
        var answer = [Int]()
        var left = 0
        var right = nums.count - 1
        
        if a < 0 {
            // When 'downward parabola' we will put the edge element (smaller elements) first.
            while (left <= right) {
                let leftTransformedVal = transform(value: nums[left], with: a, b, c)
                let rightTransformedVal = transform(value: nums[right], with: a, b, c)
                if (leftTransformedVal < rightTransformedVal) {
                    answer.append(leftTransformedVal)
                    left += 1
                } else {
                    answer.append(rightTransformedVal)
                    right -= 1
                }
            }
        } else {
            while left <= right {
                // When 'upward parabola' or a 'straight line' 
                // we will put the edge element (bigger elements) first.
                let leftTransformedVal = transform(value: nums[left], with: a, b, c)
                let rightTransformedVal = transform(value: nums[right], with: a, b, c)
                if (leftTransformedVal > rightTransformedVal) {
                    answer.append(leftTransformedVal)
                    left += 1
                } else {
                    answer.append(rightTransformedVal)
                    right -= 1
                }
            }
            // Reverse the decreasing 'answer' array.
            answer.reverse()
        }
        return answer
    }
}