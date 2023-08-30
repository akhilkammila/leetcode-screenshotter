class Solution {
public:
    vector<int> preorderTraversal(TreeNode* root) {
        vector<int> answer;
        TreeNode* curr = root;
        TreeNode* last;
        
        while (curr != nullptr) {
            // If there is no left child, go for the right child.
            // Otherwise, find the last node in the left subtree. 
            if (curr->left == nullptr) {
                answer.push_back(curr->val);
                curr = curr->right;
            } else {
                last = curr->left;
                while (last->right != nullptr && last->right != curr) {
                    last = last->right;
                }
                
                // If the last node is not modified, we let 
                // 'curr' be its right child. Otherwise, it means we 
                // have finished visiting the entire left subtree.
                if (last->right == nullptr) {
                    answer.push_back(curr->val);
                    last->right = curr;
                    curr = curr->left;
                } else {
                    last->right = nullptr;
                    curr = curr->right;
                }
            }
        }

        
        return answer;
    }
};