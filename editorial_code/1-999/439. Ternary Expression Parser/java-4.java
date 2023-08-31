class TreeNode {
    char val;
    TreeNode left;
    TreeNode right;
    
    TreeNode(char val) {
        this.val = val;
    }
}

class Solution {
    int index = 0;
    
    public String parseTernary(String expression) {
        
        // Construct Binary Tree
        TreeNode root = constructTree(expression);
        
        // Parse the binary tree till we reach the leaf node
        while (root.left != null && root.right != null) {
            if (root.val == 'T') {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        
        return String.valueOf(root.val);
    }
    
    private TreeNode constructTree(String expression) {
        
        // Storing current character of expression
        TreeNode root = new TreeNode(expression.charAt(index));

        // If last character of expression, return
        if (index == expression.length() - 1) {
            return root;
        }
        
        // Check next character
        index++;
        if (expression.charAt(index) == '?') {
            index++;
            root.left = constructTree(expression);
            index++;
            root.right = constructTree(expression);
        }
        
        return root;
    }
}