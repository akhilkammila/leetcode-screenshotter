class Solution {
    public TreeNode pruneTree(TreeNode root) {
        return containsOne(root) ? root : null;
    }

    public boolean containsOne(TreeNode node) {
        if (node == null) return false;
        
        // Check if any node in the left subtree contains a 1.
        boolean leftContainsOne = containsOne(node.left);
        
        // Check if any node in the right subtree contains a 1.
        boolean rightContainsOne = containsOne(node.right);

        // If the left subtree does not contain a 1, prune the subtree.
        if (!leftContainsOne) node.left = null;
        
        // If the right subtree does not contain a 1, prune the subtree.
        if (!rightContainsOne) node.right = null;
        
        // Return true if the current node, its left or right subtree contains a 1.
        return node.val == 1 || leftContainsOne || rightContainsOne;
    }
}