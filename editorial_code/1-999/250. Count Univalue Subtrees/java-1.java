class Solution {
    private Pair<Boolean, Integer> dfs(TreeNode node) {
        if (node == null) {
            return new Pair<>(true, 0);
        }
        
        Pair<Boolean, Integer> left = dfs(node.left);
        Pair<Boolean, Integer> right = dfs(node.right);
        boolean isLeftUniValue = left.getKey();
        boolean isRightUniValue = right.getKey();
        int count = left.getValue() + right.getValue();
        
        // If both the children form uni-value subtrees, we compare the value of
        // chidrens node with the node value.
        if (isLeftUniValue && isRightUniValue) {
            if (node.left != null && node.val != node.left.val) {
                return new Pair<>(false, count);
            }
            if (node.right != null && node.val != node.right.val) {
                return new Pair<>(false, count);
            }
            count++;
            return new Pair<>(true, count);
        }
        // Else if any of the child does not form a uni-value subtree, the subtree
        // rooted at node cannot be a uni-value subtree.
        return new Pair<>(false, count);
    }
    
    public int countUnivalSubtrees(TreeNode root) {
        return dfs(root).getValue();
    }
}