class Solution {
    // Hashmap to map old tree's nodes with new tree's nodes.
    unordered_map<Node*, NodeCopy*> newOldPairs;
public:
    NodeCopy* deepCopy(Node* root) {
        if (!root) {
            return NULL;
        }
        NodeCopy* newRoot = new NodeCopy(root->val);
        // Deep copy left subtree and attach it on new node's left.
        newRoot->left = deepCopy(root->left);
        // Deep copy right subtree and attach it on new node's right.
        newRoot->right = deepCopy(root->right);
        // Store the new node and old node's pair in hash map.
        newOldPairs[root] = newRoot;
        return newRoot;
    }

    void mapRandomPointers(Node* oldNode) {
        if (!oldNode) {
            return;
        }
        NodeCopy* newNode = newOldPairs[oldNode];
        Node* oldNodeRandom = oldNode->random;
        NodeCopy* newNodeRandom = newOldPairs[oldNodeRandom];
        // Map newNode with it's respective random node.
        newNode->random = newNodeRandom;
        // Traverse on rest nodes to map their respective new node's random pointers.
        mapRandomPointers(oldNode->left);
        mapRandomPointers(oldNode->right);
    }

    NodeCopy* copyRandomBinaryTree(Node* root) {
        // Create a new tree for each node of old tree and map new node with old respective node.
        NodeCopy* newRoot = deepCopy(root);
        // We will assign random pointers of new tree to respective correct new nodes.
        mapRandomPointers(root);
        return newRoot;
    }
};