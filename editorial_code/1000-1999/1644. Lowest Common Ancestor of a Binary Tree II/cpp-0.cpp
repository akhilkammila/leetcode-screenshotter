TreeNode* LCA(TreeNode* node, TreeNode* p, TreeNode* q) {
    if (node == NULL || node == p || node == q)
        return node;
    TreeNode* left = LCA(node->left, p, q);
    TreeNode* right = LCA(node->right, p, q);
    if (left && right)
        return node;
    else if (left)
        return left;
    else
        return right;
}