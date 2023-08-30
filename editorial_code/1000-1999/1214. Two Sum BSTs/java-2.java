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
    private void dfs(TreeNode currNode, Set<Integer> nodeSet) {
        if (currNode == null) {
            return;
        }
        dfs(currNode.left, nodeSet);
        nodeSet.add(currNode.val);
        dfs(currNode.right, nodeSet);
    }
    
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        Set<Integer> nodeSet1 = new HashSet<>();
        Set<Integer> nodeSet2 = new HashSet<>();
        dfs(root1, nodeSet1);
        dfs(root2, nodeSet2);

        for (int value1 : nodeSet1) {
            if (nodeSet2.contains(target - value1)) {
                return true;
            }
        }
        
        return false;
    }   
}