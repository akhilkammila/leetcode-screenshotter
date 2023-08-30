class Solution {    
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        
        // Note that we add currNode's right child to the stack first.
        while (!stack.isEmpty()) {
            TreeNode currNode = stack.peek();
            stack.pop();
            if (currNode != null) {
                answer.add(currNode.val);
                stack.add(currNode.right);
                stack.add(currNode.left);
            }
        }
        
        return answer;
    }
}