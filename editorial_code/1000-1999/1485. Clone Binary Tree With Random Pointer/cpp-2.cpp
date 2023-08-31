class Solution {
    // Hashmap to map old tree's nodes with new tree's nodes.
    unordered_map<Node*, NodeCopy*> seen;
  
    // Function to traverse on the sub graph of 'root'.
    NodeCopy* bfs(Node* root) {
        if (!root) {
            return NULL;
        }
        queue<Node*> pending;
        // Push root in queue, mark it as seen and, 
        // store its respective new node.
        pending.push(root);
        seen[root] = new NodeCopy(root->val);
        
        while (pending.size()) {
            Node* oldNode = pending.front();
            pending.pop();
            NodeCopy* newNode = seen[oldNode];
            
            // Traverse on left, right and random edges one-by-one, if nodes exist and, 
            // not already seen then we push it in queue, create a copy and attach it to new node.
            if (oldNode->left) {
                if (seen.find(oldNode->left) == seen.end()) {
                    pending.push(oldNode->left);
                    seen[oldNode->left] = new NodeCopy(oldNode->left->val);
                }
                newNode->left = seen[oldNode->left];
            }
            if (oldNode->right) {
                if (seen.find(oldNode->right) == seen.end()) {
                    pending.push(oldNode->right);
                    seen[oldNode->right] = new NodeCopy(oldNode->right->val);
                }
                newNode->right = seen[oldNode->right];
            }
            if (oldNode->random) {
                if (seen.find(oldNode->random) == seen.end()) {
                    pending.push(oldNode->random);
                    seen[oldNode->random] = new NodeCopy(oldNode->random->val);
                }
                newNode->random = seen[oldNode->random];
            }
        }
        
        return seen[root];
    }

public:
    NodeCopy* copyRandomBinaryTree(Node* root) {
        // Traverse on each node of the given tree.
        NodeCopy* newRoot = bfs(root);
        return newRoot;
    }
};