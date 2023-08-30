class Solution {
public:
    vector<TreeNode*> generateTrees(int n) {
        vector<vector<TreeNode*>> dp(n + 1);
        dp[0].push_back(NULL);

        for (int numberOfNodes = 1; numberOfNodes <= n; numberOfNodes ++) {
            for (int i = 1; i <= numberOfNodes; i ++) {
                int j = numberOfNodes - i;
                for (auto left : dp[i - 1]) {
                    for (auto right : dp[j]) {
                        TreeNode* root = new TreeNode(i, left, clone(right, i));
                        dp[numberOfNodes].push_back(root);
                    }
                }
            }
        }
        return dp[n];
    }

private:
    TreeNode* clone(TreeNode* node, int offset) {
        if (node == NULL) {
            return NULL;
        }
        TreeNode* clonedNode = new TreeNode(node->val + offset);
        clonedNode->left = clone(node->left, offset);
        clonedNode->right = clone(node->right, offset);
        return clonedNode;
    }
};