class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public boolean dfs(TreeNode node, int index, int n) {
        if (node == null) {
            return true;
        }
        // If index assigned to current node is greater or equal to the number of nodes
        // in tree, then the given tree is not a complete binary tree.
        if (index >= n) {
            return false;
        }
        // Recursively move to left and right subtrees.
        return dfs(node.left, 2 * index + 1, n) &&
                dfs(node.right, 2 * index + 2, n);
    }

    public boolean isCompleteTree(TreeNode root) {
        return dfs(root, 0, countNodes(root));
    }
}