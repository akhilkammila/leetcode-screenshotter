class Solution {
    var sumFreq: [Int: Int] = [:]
    var maxFreq: Int = 0
    var maxFreqSums: [Int] = [Int]()
    
    func findTreeSum(_ root: TreeNode?) -> Int {
        guard let root = root else {
            return 0
        }
        // Current root's tree's sum.
        return root.val + findTreeSum(root.left) + findTreeSum(root.right)
    }
    
    func preOrderTraversal(_ root: TreeNode?) {
        guard let root = root else {
            return
        }
        
        // Find current node's tree's sum.
        let currSum = findTreeSum(root)
        sumFreq[currSum] = (sumFreq[currSum] ?? 0) + 1
        maxFreq = max(maxFreq, sumFreq[currSum]!)
        
        // Iterate on left and right subtrees and find their sums.
        preOrderTraversal(root.left)
        preOrderTraversal(root.right)
    }
    
    func findFrequentTreeSum(_ root: TreeNode?) -> [Int] {
        // Traverse on all nodes one by one, and find it's tree's sum.
        preOrderTraversal(root)
        
        sumFreq.forEach { sum in
            if sum.value == maxFreq {
                maxFreqSums.append(sum.key)
            }
        }
        
        return maxFreqSums
    }
}