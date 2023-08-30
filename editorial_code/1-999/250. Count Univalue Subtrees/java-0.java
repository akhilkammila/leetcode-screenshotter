class Solution {
    int count = 0;

    public boolean dfs(TreeNode node) {
        if (node == null) {
            return true;
        }

        boolean left = dfs(node.left);
        boolean right = dfs(node.right);

        // If both the children form uni-value subtrees, we compare the value of
        // chidren's node with the node value.
        if (left && right) {
            if (node.left != null && node.left.val != node.val) {
                return false;
            }
            if (node.right != null && node.right.val != node.val) {
                return false;
            }
            count++;
            return true;
        }
        // Else if any of the child does not form a uni-value subtree, the subtree
        // rooted at node cannot be a uni-value subtree.
        return false;
    }

    public int countUnivalSubtrees(TreeNode root) {
        dfs(root);
        return count;
    }
}