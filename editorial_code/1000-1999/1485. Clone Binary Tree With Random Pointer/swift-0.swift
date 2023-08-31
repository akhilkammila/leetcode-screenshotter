class Solution {
    // Hashmap to map old tree's nodes with new tree's nodes.
    var newOldPairs: [Node?: NodeCopy?] = [:]
    
    func deepCopy(_ root: Node?) -> NodeCopy? {
        guard let root = root else { 
            return nil 
        }
        let newRoot = NodeCopy(root.val)
        // Deep copy left subtree and attach it on new node's left.
        newRoot.left = deepCopy(root.left)
        // Deep copy right subtree and attach it on new node's right.
        newRoot.right = deepCopy(root.right)
        // Store the new node and old node's pair in hash map.
        newOldPairs[root] = newRoot
        return newRoot
    }

    func mapRandomPointers(_ oldNode: Node?) {
        guard let oldNode = oldNode else { 
            return 
        }
        if let newNode = newOldPairs[oldNode], 
            let oldNodeRandom = oldNode.random,
            let newNodeRandom = newOldPairs[oldNodeRandom] {
            // Map newNode with it's respective random node.
            newNode?.random = newNodeRandom
        }
        // Traverse on rest nodes to map their respective new node's random pointers.
        mapRandomPointers(oldNode.left)
        mapRandomPointers(oldNode.right)
    }
    
    func copyRandomBinaryTree(_ root: Node?) -> NodeCopy? {
        // Create a new tree for each node of old tree and map new node with old respective node.
        let newRoot = deepCopy(root)
        // We will assign random pointers of new tree to respective correct new nodes.
        mapRandomPointers(root)
        return newRoot
    }
}