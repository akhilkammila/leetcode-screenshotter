class Solution {
    func sortTransformedArray(_ nums: [Int], _ a: Int, _ b: Int, _ c: Int) -> [Int] {
        var answer = [Int]()
        for num in nums {
            // Push transformed value in the 'answer' array.
            answer.append((a * num * num) + (b * num) + c)
        }
        // Sort the array of transformed values.
        answer.sort()
        return answer
    }
}