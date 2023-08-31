class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ans = LCA(root, p, q);
        if (ans == p) // check if q is in the subtree of p
            return dfs(p, q) ? p : null;
        else if (ans == q) // check if p is in the subtree of q
            return dfs(q, p) ? q : null;
        return ans; 
    }

    private TreeNode LCA(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null || node == p || node == q)
            return node;
        TreeNode left = LCA(node.left, p, q);
        TreeNode right = LCA(node.right, p, q);
        if (left != null && right != null)
            return node;
        else if (left != null)
            return left;
        else
            return right;
    }

    private boolean dfs(TreeNode node, TreeNode target) {
        if (node == target)
            return true;
        if (node == null)
            return false;
        return dfs(node.left, target) || dfs(node.right, target);
    }
}