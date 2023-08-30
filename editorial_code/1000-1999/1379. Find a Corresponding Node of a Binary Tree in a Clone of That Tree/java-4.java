class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        Deque<TreeNode> queue_o = new ArrayDeque();
        queue_o.offer(original);
        
        Deque<TreeNode> queue_c = new ArrayDeque();
        queue_c.offer(cloned);

        while (!queue_o.isEmpty()) {
            TreeNode node_o = queue_o.poll();
            TreeNode node_c = queue_c.poll();
            
            if (node_o == target) {
                return node_c;   
            }
            
            if (node_o.left != null) {
                queue_o.offer(node_o.left);
                queue_c.offer(node_c.left);
            }
            if (node_o.right != null) {
                queue_o.offer(node_o.right);
                queue_c.offer(node_c.right);
            }
        }
        return null;
    }
}