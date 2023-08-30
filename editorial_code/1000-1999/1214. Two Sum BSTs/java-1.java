/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private boolean binarySearch(TreeNode root2, int target2) {
        if (root2 == null) {
            return false;
        }
        if (root2.val == target2) {
            return true;
        } else if (root2.val > target2) {
            return binarySearch(root2.left, target2);
        } else {
            return binarySearch(root2.right, target2);
        }
    }
    private boolean dfs(TreeNode root1, TreeNode root2, int target) {
        if (root1 == null) {
            return false;
        }
        if (binarySearch(root2, target - root1.val)) {
            return true;
        }
        return dfs(root1.left, root2, target) || dfs(root1.right, root2, target);
    }
    
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        return dfs(root1, root2, target);
    }
}