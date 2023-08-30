class Solution {
public:
    bool verifyPreorder(vector<int>& preorder) {
        int minLimit = INT_MIN;
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
};