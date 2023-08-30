class Solution {
public:
    int countNodes(TreeNode* root) {
        if (root == nullptr) {
            return 0;
        }
        return 1 + countNodes(root->left) + countNodes(root->right);
    }

    bool dfs(TreeNode* node, int index, int n) {
        if (node == nullptr) {
            return true;
        }
        // If index assigned to current node is greater or equal to the number of nodes
        // in tree, then the given tree is not a complete binary tree.
        if (index >= n) {
            return false;
        }
        // Recursively move to left and right subtrees.
        return dfs(node->left, 2 * index + 1, n) &&
               dfs(node->right, 2 * index + 2, n);
    }

    bool isCompleteTree(TreeNode* root) {
        return dfs(root, 0, countNodes(root));
    }
};