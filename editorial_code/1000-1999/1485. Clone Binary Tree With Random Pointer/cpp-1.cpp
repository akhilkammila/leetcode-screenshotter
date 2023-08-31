class Solution {
    // Hashmap to map old tree's nodes with new tree's nodes.
    unordered_map<Node*, NodeCopy*> seen;
  
    // Function to traverse on the sub graph of 'root'.
    NodeCopy* dfs(Node* root) {
        if (!root) {
            return NULL;
        }
        if (seen.find(root) != seen.end()) {
            return seen[root];
        }

        NodeCopy* newRoot = new NodeCopy(root->val);
        // Mark old root as seen and store its respective new node.
        seen[root] = newRoot;
        
        // Traverse on all 3 edges of root and attach respective new node
        // to the newRoot.
        newRoot->left = dfs(root->left);
        newRoot->right = dfs(root->right);
        newRoot->random = dfs(root->random);
        return newRoot;
    }

public:
    NodeCopy* copyRandomBinaryTree(Node* root) {
        // Traverse on each node of the given tree.
        NodeCopy* newRoot = dfs(root);
        return newRoot;
    }
};