class Solution {
    public int pseudoPalindromicPaths (TreeNode root) {
        int count = 0, path = 0;
        
        Deque<Pair<TreeNode, Integer>> stack = new ArrayDeque();
        stack.push(new Pair(root, 0));
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> p = stack.pop();
            TreeNode node = p.getKey();
            path = p.getValue();

            if (node != null) {
                // compute occurences of each digit 
                // in the corresponding register
                path = path ^ (1 << node.val);
                // if it's a leaf check if the path is pseudo-palindromic
                if (node.left == null && node.right == null) {
                    // check if at most one digit has an odd frequency
                    if ((path & (path - 1)) == 0) {
                        ++count;
                    }
                } else {
                    stack.push(new Pair(node.right, path));
                    stack.push(new Pair(node.left, path));
                }
            }
        }
        return count;
    }
}