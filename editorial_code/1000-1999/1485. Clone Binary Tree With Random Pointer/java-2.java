class Solution {
    // Hashmap to map old tree's nodes with new tree's nodes.
    private HashMap<Node, NodeCopy> seen = new HashMap<>();

    private  NodeCopy bfs(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> pending = new LinkedList<>();
        // Push root in queue, mark it as seen and, 
        // store its respective new node.
        pending.add(root);
        seen.put(root, new NodeCopy(root.val));
        
        while (!pending.isEmpty()) {
            Node oldNode = pending.poll();
            NodeCopy newNode = seen.get(oldNode);
            
            // Traverse on left, right and random edges one-by-one, if nodes exist and, 
            // not already seen then we push it in queue, create a copy and attach it to new node.
            if (oldNode.left != null) {
                if (!seen.containsKey(oldNode.left)) {
                    pending.add(oldNode.left);
                    seen.put(oldNode.left, new NodeCopy(oldNode.left.val));
                }
                newNode.left = seen.get(oldNode.left);
            }
            if (oldNode.right != null) {
                if (!seen.containsKey(oldNode.right)) {
                    pending.add(oldNode.right);
                    seen.put(oldNode.right, new NodeCopy(oldNode.right.val));
                }
                newNode.right = seen.get(oldNode.right);
            }
            if (oldNode.random != null) {
                if (!seen.containsKey(oldNode.random)) {
                    pending.add(oldNode.random);
                    seen.put(oldNode.random, new NodeCopy(oldNode.random.val));
                }
                newNode.random = seen.get(oldNode.random);
            }
        }
        return seen.get(root);
    }

    public NodeCopy copyRandomBinaryTree(Node root) {
        // Traverse on each node of the given tree.
        NodeCopy newRoot = bfs(root);
        return newRoot;
    }
}