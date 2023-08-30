class Solution {
public:
    bool verifyPreorder(vector<int>& preorder) {
        int i = 0;
        return helper(preorder, i, INT_MIN, INT_MAX);
    }
    
    bool helper(vector<int>& preorder, int& i, int minLimit, int maxLimit) {
        if (i == preorder.size()) {
            return true;
        }
        
        int root = preorder[i];
        if (root <= minLimit || root >= maxLimit) {
            return false;
        }
        
        i++;
        bool left = helper(preorder, i, minLimit, root);
        bool right = helper(preorder, i, root, maxLimit);
        return left || right;
    }
};