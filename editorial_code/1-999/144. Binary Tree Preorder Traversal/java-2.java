class Solution {    
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        TreeNode curr = root, last;
        
        while (curr != null) {
            // If there is no left child, go for the right child.
            // Otherwise, find the last node in the left subtree. 
            if(curr.left == null) {
                answer.add(curr.val);
                curr = curr.right;
            } else {
                last = curr.left;
                while (last.right != null && last.right != curr) {
                    last = last.right;
                }

                // If the last node is not modified, we let 
                // 'curr' be its right child. Otherwise, it means we 
                // have finished visiting the entire left subtree.
                if (last.right == null) {
                    answer.add(curr.val);
                    last.right = curr;
                    curr = curr.left;
                } else {
                    last.right = null;
                    curr = curr.right;
                }
            }
        }
        
        return answer;
    }
}