class Solution {
    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        // If only one of child is non-null, then go into that recursion.
        if (root.left == null) {
            return 1 + dfs(root.right);
        } else if (root.right == null) {
            return 1 + dfs(root.left);
        }
        
        // Both children are non-null, hence call for both children.
        return 1 + Math.min(dfs(root.left), dfs(root.right));
    }
    
    public int minDepth(TreeNode root) {
        return dfs(root);
    }
}