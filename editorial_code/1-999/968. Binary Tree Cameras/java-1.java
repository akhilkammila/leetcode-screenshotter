class Solution {
    int ans;
    Set<TreeNode> covered;
    public int minCameraCover(TreeNode root) {
        ans = 0;
        covered = new HashSet();
        covered.add(null);

        dfs(root, null);
        return ans;
    }

    public void dfs(TreeNode node, TreeNode par) {
        if (node != null) {
            dfs(node.left, node);
            dfs(node.right, node);

            if (par == null && !covered.contains(node) ||
                    !covered.contains(node.left) ||
                    !covered.contains(node.right)) {
                ans++;
                covered.add(node);
                covered.add(par);
                covered.add(node.left);
                covered.add(node.right);
            }
        }
    }
}