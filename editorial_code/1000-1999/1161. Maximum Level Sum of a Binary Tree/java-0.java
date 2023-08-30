class Solution {
    public int maxLevelSum(TreeNode root) {
        int maxSum = Integer.MIN_VALUE;
        int ans = 0, level = 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            level++;
            int sumAtCurrentLevel = 0;
            // Iterate over all the nodes in the current level.
            for (int sz = q.size(); sz > 0; --sz) {
                TreeNode node = q.poll();
                sumAtCurrentLevel += node.val;

                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }

            if (maxSum < sumAtCurrentLevel) {
                maxSum = sumAtCurrentLevel;
                ans = level;
            }
        }

        return ans;
    }
}