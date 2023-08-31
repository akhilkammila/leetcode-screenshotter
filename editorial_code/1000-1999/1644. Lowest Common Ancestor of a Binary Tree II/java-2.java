class Solution {
    boolean nodesFound = false;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ans = dfs(root, p, q);
        return nodesFound ? ans : null;
    }
    private TreeNode dfs(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null)
          return null;
        TreeNode left = dfs(node.left, p, q);
        TreeNode right = dfs(node.right, p, q);
        int conditions = 0;
        if (node == p || node == q)
          conditions++;
        if (left != null)
          conditions++;
        if (right != null)
          conditions++;
        if (conditions == 2)
          nodesFound = true;

        if ((left != null && right != null) || node == p || node == q) 
            return node;
        return left != null ? left : right;
    }
}