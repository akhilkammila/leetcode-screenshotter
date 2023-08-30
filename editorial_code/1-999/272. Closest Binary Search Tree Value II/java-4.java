class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Deque<Integer> queue = new LinkedList<>();
        dfs(root, queue, k, target);
        return new ArrayList<>(queue);
    }
    
    public void dfs(TreeNode node, Deque<Integer> queue, int k, double target) {
        if (node == null) {
            return;
        }
        
        dfs(node.left, queue, k, target);
        queue.add(node.val);
        if (queue.size() > k) {
            if (Math.abs(target - queue.peekFirst()) < Math.abs(target - queue.peekLast())) {
                queue.removeLast();
                return;
            } else {
                queue.removeFirst();
            }
        }

        dfs(node.right, queue, k, target);
    }
}