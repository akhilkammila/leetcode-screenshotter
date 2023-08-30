class Solution {
   public:
    // CONSTANTS
    const int MOD_1 = 1000000007;
    const int MOD_2 = 2147483647;

    // Hashing a Node
    pair<unsigned long long, unsigned long long> hashSubtreeAtNode(TreeNode* node, bool needToAdd) {
        if (node == nullptr) return {3, 7};

        auto left = hashSubtreeAtNode(node->left, needToAdd);
        auto right = hashSubtreeAtNode(node->right, needToAdd);

        auto left1 = (left.first << 5) % MOD_1;
        auto right1 = (right.first << 1) % MOD_1;
        auto left2 = (left.second << 7) % MOD_2;
        auto right2 = (right.second << 1) % MOD_2;

        pair hashpair = {(left1 + right1 + node->val) % MOD_1,
                         (left2 + right2 + node->val) % MOD_2};

        if (needToAdd) memo.push_back(hashpair);

        return hashpair;
    }

    // Vector to store hashed value of each node.
    vector<pair<unsigned long long, unsigned long long>> memo;

    bool isSubtree(TreeNode* root, TreeNode* subRoot) {
        // Calling and adding hash to vector
        hashSubtreeAtNode(root, true);

        // Storing hashed value of subRoot for comparison
        pair<unsigned long long, unsigned long long> s = hashSubtreeAtNode(subRoot, false);

        // Check if hash of subRoot is present in memo
        return find(memo.begin(), memo.end(), s) != memo.end();
    }
};