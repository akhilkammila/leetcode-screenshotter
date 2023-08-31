class Solution {
    // Hashmap to map old tree's nodes with new tree's nodes.
    var seen: [Node?: NodeCopy?] = [:]
    
    // Function to traverse on the sub graph of 'root'.
    func dfs(_ root: Node?) -> NodeCopy? {
        guard let root = root else { 
            return nil 
        }
        if let storedNode = seen[root] {
            return storedNode
        }

        let newRoot = NodeCopy(root.val)
        // Mark old root as seen and store its respective new node.
        seen[root] = newRoot
        
        // Traverse on all 3 edges of root and attach respective new node
        // to the newRoot.
        newRoot.left = dfs(root.left)
        newRoot.right = dfs(root.right)
        newRoot.random = dfs(root.random)
        return newRoot
    }
    
    func copyRandomBinaryTree(_ root: Node?) -> NodeCopy? {
        // Traverse on each node of the given tree.
        let newRoot = dfs(root);
        return newRoot
    }
}