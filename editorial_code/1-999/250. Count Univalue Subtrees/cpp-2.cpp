class Solution {
public:
    bool dfs(TreeNode* node, int& count) {
        if (node == nullptr) {
            return true;
        }

        bool isLeftUniValue = dfs(node->left, count);
        bool isRightUniValue = dfs(node->right, count);

        // If both the children form uni-value subtrees, we compare the value of
        // chidren's node with the node value.
        if (isLeftUniValue && isRightUniValue) {
            if (node->left != nullptr && node->left->val != node->val) {
                return false;
            }
            if (node->right != nullptr && node->right->val != node->val) {
                return false;
            }
            count++;
            return true;
        }
        // Else if any of the child does not form a uni-value subtree, the subtree
        // rooted at node cannot be a uni-value subtree.
        return false;
    }

    int countUnivalSubtrees(TreeNode* root) {
        int count = 0;
        dfs(root, count);
        return count;
    }
};