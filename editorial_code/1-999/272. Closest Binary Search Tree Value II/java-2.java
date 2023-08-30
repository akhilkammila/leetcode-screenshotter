class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> arr = new ArrayList<>();
        dfs(root, arr);
        
        int start = 0;
        double minDiff = Double.MAX_VALUE;
        
        for (int i = 0; i < arr.size(); i++) {
            if (Math.abs(arr.get(i) - target) < minDiff) {
                minDiff = Math.abs(arr.get(i) - target);
                start = i;
            }
        }
        
        int left = start;
        int right = start + 1;
        
        while (right - left - 1 < k) {
            // Be careful to not go out of bounds
            if (left < 0) {
                right += 1;
                continue;
            }

            if (right == arr.size() || Math.abs(arr.get(left) - target) <= Math.abs(arr.get(right) - target)) {
                left -= 1;
            } else {
                right += 1;
            }
        }
        
        return arr.subList(left + 1, right);
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