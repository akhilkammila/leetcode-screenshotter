class Solution {
public:
    pair<bool, int> dfs(TreeNode* node) {
        if (!node) {
            return {true, 0};
        }

        auto left = dfs(node->left);
        auto right = dfs(node->right);
        bool isLeftUniValue = left.first;
        bool isRightUniValue = right.first;
        int count = left.second + right.second;

        // If both the children form uni-value subtrees, we compare the value of
        // chidrens node with the node value.
        if (isLeftUniValue && isRightUniValue) {
            if (node->left && node->val != node->left->val) {
                return {false, count};
            }
            if (node->right && node->val != node->right->val) {
                return {false, count};
            }
            return {true, count + 1};
        }
        // Else if any of the child does not form a uni-value subtree, the subtree
        // rooted at node cannot be a uni-value subtree.
        return {false, count};
    }

    int countUnivalSubtrees(TreeNode* root) {
        return dfs(root).second;
    }
};