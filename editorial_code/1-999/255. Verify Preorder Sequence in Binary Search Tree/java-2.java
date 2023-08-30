class Solution {
    public boolean verifyPreorder(int[] preorder) {
        int[] i = {0};
        return helper(preorder, i, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    public boolean helper(int[] preorder, int[] i, int minLimit, int maxLimit) {
        if (i[0] == preorder.length) {
            return true;
        }
        
        int root = preorder[i[0]];
        if (root <= minLimit || root >= maxLimit) {
            return false;
        }
        
        i[0]++;
        boolean left = helper(preorder, i, minLimit, root);
        boolean right = helper(preorder, i, root, maxLimit);
        return left || right;
    }
}