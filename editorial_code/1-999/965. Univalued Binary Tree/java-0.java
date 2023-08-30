class Solution {
    List<Integer> vals;
    public boolean isUnivalTree(TreeNode root) {
        vals = new ArrayList();
        dfs(root);
        for (int v: vals)
            if (v != vals.get(0))
                return false;
        return true;
    }

    public void dfs(TreeNode node) {
        if (node != null) {
            vals.add(node.val);
            dfs(node.left);
            dfs(node.right);
        }
    }
}