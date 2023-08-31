class Solution {
    // Hashmap to map old tree's nodes with new tree's nodes.
    private HashMap<Node, NodeCopy> seen = new HashMap<>();

    private  NodeCopy dfs(Node root) {
        if (root == null) {
            return null;
        }
        if (seen.containsKey(root)) {
            return seen.get(root);
        }

        NodeCopy newRoot = new NodeCopy(root.val);
        // Mark old root as seen and store its respective new node.
        seen.put(root, newRoot);
        
        // Traverse on all 3 edges of root and attach respective new node
        // to the newRoot.
        newRoot.left = dfs(root.left);
        newRoot.right = dfs(root.right);
        newRoot.random = dfs(root.random);
        return newRoot;
    }

    public NodeCopy copyRandomBinaryTree(Node root) {
        // Traverse on each node of the given tree.
        NodeCopy newRoot = dfs(root);
        return newRoot;
    }
}