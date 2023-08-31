class Solution {
    var sumFreq: [Int: Int] = [:]
    var maxFreq: Int = 0
    var ans: [Int] = [Int]()
    
    func subtreeSum(_ root: TreeNode?) -> Int {
        guard let root = root else {
            return 0
        }
        
        // Get left and right subtree's sum.
        let leftSubtreeSum = subtreeSum(root.left)
        let rightSubtreeSum = subtreeSum(root.right)
        
        // Use child's tree's sums to get current root's tree's sum
        let currSum = root.val + leftSubtreeSum + rightSubtreeSum
        
        sumFreq[currSum] = (sumFreq[currSum] ?? 0) + 1
        maxFreq = max(maxFreq, sumFreq[currSum]!)
        return currSum
    }
    
    func findFrequentTreeSum(_ root: TreeNode?) -> [Int] {
        // Traverse on all nodes one by one, and find it's tree's sum.
        subtreeSum(root)
        
        sumFreq.forEach { sum in
            if sum.value == maxFreq {
                ans.append(sum.key)
            }
        }
        
        return ans
    }
}