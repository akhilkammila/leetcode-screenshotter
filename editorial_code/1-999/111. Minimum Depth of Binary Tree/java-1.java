class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int depth = 1;
        
        while (q.isEmpty() == false) {
            int qSize = q.size();
            
            while (qSize > 0) {
                qSize--;
                
                TreeNode node = q.remove();
                // Since we added nodes without checking null, we need to skip them here.
                if (node == null) {
                    continue;
                }
                
                // The first leaf would be at minimum depth, hence return it.
                if (node.left == null && node.right == null) {
                    return depth;
                }
                
                q.add(node.left);
                q.add(node.right);
            }
            depth++;
        }
        return -1;
    }
};