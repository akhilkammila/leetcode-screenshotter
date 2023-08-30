class Solution {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root).node;
    }

    // Return the result of the subtree at this node.
    public Result dfs(TreeNode node) {
        if (node == null) return new Result(null, 0);
        Result L = dfs(node.left),
               R = dfs(node.right);
        if (L.dist > R.dist) return new Result(L.node, L.dist + 1);
        if (L.dist < R.dist) return new Result(R.node, R.dist + 1);
        return new Result(node, L.dist + 1);
    }
}

/**
 * The result of a subtree is:
 *       Result.node: the largest depth node that is equal to or
 *                    an ancestor of all the deepest nodes of this subtree.
 *       Result.dist: the number of nodes in the path from the root
 *                    of this subtree, to the deepest node in this subtree.
 */
class Result {
    TreeNode node;
    int dist;
    Result(TreeNode n, int d) {
        node = n;
        dist = d;
    }
}