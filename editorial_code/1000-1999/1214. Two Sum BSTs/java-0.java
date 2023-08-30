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
    private void dfs(TreeNode currNode, List<Integer> nodeList) {
        if (currNode == null) {
            return;
        }
        node_list.add(currNode.val);
        dfs(currNode.left, nodeList);
        dfs(currNode.right, nodeList);
    }

    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        List<Integer> nodeList1 = new ArrayList<>();
        List<Integer> nodeList2 = new ArrayList<>();
        dfs(root1, nodeList1);
        dfs(root2, nodeList2);

        for (int a : nodeList1) {
            for (int b : nodeList2) {
                if (a + b == target) {
                    return true;
                }
            }
        }
        return false;
    }
}