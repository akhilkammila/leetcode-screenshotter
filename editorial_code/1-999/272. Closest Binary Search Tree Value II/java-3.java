class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> arr = new ArrayList<>();
        dfs(root, arr);
        
        int left = 0;
        int right = arr.size() - k;
        
        while (left < right) {
            int mid = (left + right) / 2;
            if (Math.abs(target - arr.get(mid + k)) < Math.abs(target - arr.get(mid))) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return arr.subList(left, left + k);
    }
    
    public void dfs(TreeNode node, List<Integer> arr) {
        if (node == null) {
            return;
        }
        
        dfs(node.left, arr);
        arr.add(node.val);
        dfs(node.right, arr);
    }
}