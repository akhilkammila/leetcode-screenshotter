class Solution {
    public boolean verifyPreorder(int[] preorder) {
        int minLimit = Integer.MIN_VALUE;
        int i = 0;
        
        for (int num: preorder) {
            while (i > 0 && preorder[i - 1] < num) {
                minLimit = preorder[i - 1];
                i--;
            }
            
            if (num <= minLimit) {
                return false;
            }
            
            preorder[i] = num;
            i++;
        }
        
        return true;
    }
}