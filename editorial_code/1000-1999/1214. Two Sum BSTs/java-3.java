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
        dfs(currNode.left, nodeList);
        nodeList.add(currNode.val);
        dfs(currNode.right, nodeList);
    }
    
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        List<Integer> nodeList1 = new ArrayList<>();
        List<Integer> nodeList2 = new ArrayList<>();
        dfs(root1, nodeList1);
        dfs(root2, nodeList2);

        int pointer1 = 0, pointer2 = nodeList2.size() - 1;
        while (pointer1 < nodeList1.size() && pointer2 >= 0) {
            if (nodeList1.get(pointer1) + nodeList2.get(pointer2) == target) {
                return true;
            } else if (nodeList1.get(pointer1) + nodeList2.get(pointer2) < target) {
                pointer1++;
            } else {
                pointer2--;
            }
        }
        
        return false;
    }   
}