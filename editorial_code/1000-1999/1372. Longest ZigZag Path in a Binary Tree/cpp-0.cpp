class Solution {
public:
    int pathLength = 0;
    void dfs(TreeNode* node, bool goLeft, int steps) {
        if (node == nullptr) {
            return;
        }
        pathLength = max(pathLength, steps);
        if (goLeft) {
            dfs(node->left, false, steps + 1);
            dfs(node->right, true, 1);
        } else {
            dfs(node->left, false, 1);
            dfs(node->right, true, steps + 1);
        }
    }

    int longestZigZag(TreeNode* root) {
        dfs(root, false, 0);
        dfs(root, true, 0);
        return pathLength;
    }
};