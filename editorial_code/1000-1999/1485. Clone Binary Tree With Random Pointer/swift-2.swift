class Solution {
    // Hashmap to map old tree's nodes with new tree's nodes.
    var seen: [Node: NodeCopy] = [:]
    
    // Function to traverse on the sub graph of 'root'.
    func bfs(_ root: Node?) -> NodeCopy? {
        guard let root = root else { 
            return nil 
        }
        
        // Push root in queue, mark it as seen and, 
        // store its respective new node.
        var pending: [Node] = [root]
        var start = 0, end = 0
        seen[root] = NodeCopy(root.val)
        
        while start <= end {
            let oldNode = pending[start]
            start += 1
            guard let newNode = seen[oldNode] else {
                continue
            }
            
            // Traverse on left, right and random edges one-by-one, if nodes exist and, 
            // not already seen then we push it in queue, create a copy and attach it to new node.
            if let node = oldNode.left {
                if seen[node] == nil {
                    pending.append(node)
                    seen[node] = NodeCopy(node.val)
                    end += 1
                }
                newNode.left = seen[node]!
            }
            if let node = oldNode.right {
                if seen[node] == nil {
                    pending.append(node)
                    seen[node] = NodeCopy(node.val)
                    end += 1
                }
                newNode.right = seen[node]!
            }
            if let node = oldNode.random {
                if seen[node] == nil {
                    pending.append(node)
                    seen[node] = NodeCopy(node.val)
                    end += 1
                }
                newNode.random = seen[node]!
            }
        }
        
        return seen[root]
    }
    
    func copyRandomBinaryTree(_ root: Node?) -> NodeCopy? {
        // Traverse on each node of the given tree.
        let newRoot = bfs(root);
        return newRoot
    }
}