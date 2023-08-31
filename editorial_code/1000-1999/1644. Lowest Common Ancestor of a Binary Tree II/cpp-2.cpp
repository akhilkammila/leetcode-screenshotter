class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        bool nodesFound = false;

        function<TreeNode*(TreeNode*)> dfs = [&](TreeNode* node) {
            if (!node)
              return node;
            TreeNode* left = dfs(node->left);
            TreeNode* right = dfs(node->right);
            int conditions = 0;
            if (node == p || node == q)
              conditions++;
            if (left != NULL)
              conditions++;
            if (right != NULL)
              conditions++;
            if (conditions == 2)
              nodesFound = true;
            
            if ((left && right) || (node == p) || (node == q))
              return node;
            return left ? left : right;
        };

        TreeNode* ans = dfs(root);
        return nodesFound ? ans : NULL;
    }
};