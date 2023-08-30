class Solution {
public:
    vector<int> preorderTraversal(TreeNode* root) {
        vector<int> answer;
        stack<TreeNode*> iStack;
        iStack.push(root);
        
        // Note that we add currNode's right child to the stack first.
        while (!iStack.empty()) {
            TreeNode* currNode = iStack.top();
            iStack.pop();
            if (currNode != nullptr) {
                answer.push_back(currNode -> val);
                iStack.push(currNode -> right);
                iStack.push(currNode -> left);
            }
        }
        
        return answer;
    }
};