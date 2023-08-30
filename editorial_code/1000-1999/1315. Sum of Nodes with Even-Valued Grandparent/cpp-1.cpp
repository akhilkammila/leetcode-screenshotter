class Solution {
public:
    int findVal(TreeNode* root) {
        return root ? root->val : 0;
    }
    
    int sumEvenGrandparent(TreeNode* root) {
        if (root == NULL) {
            return 0;
        }
        
        queue<TreeNode*> q;
        q.push(root);
        
        int sum = 0;
        while (!q.empty()) {
            TreeNode* curr = q.front();
            q.pop();
            
            // If the node value is even, then Check the four grandchildren
            // And add the value.
            if (curr->val % 2 == 0) {
                if (curr->left) {
                    sum += findVal(curr->left->left) + findVal(curr->left->right);
                }
                if (curr->right) {
                    sum += findVal(curr->right->left) + findVal(curr->right->right);
                }
            }
            
            // Add the non-null child of the current node.
            if (curr->left) 
                q.push(curr->left);
            if (curr->right)
                q.push(curr->right);
        }
        
        return sum;
    }
};