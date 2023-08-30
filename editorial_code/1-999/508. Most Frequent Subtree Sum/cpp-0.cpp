class Solution {
public:
    int findTreeSum(TreeNode* root) {
        if (!root) {
            return 0;
        }
        // Current root's tree's sum.
        return root -> val + findTreeSum(root -> left) + findTreeSum(root -> right);
    }
    
    void preOrderTraversal(TreeNode* root, unordered_map<int, int>& sumFreq, int& maxFreq) {
        if (!root) {
            return;
        }
        
        // Find current node's tree's sum.
        int currSum = findTreeSum(root);
        sumFreq[currSum]++;
        maxFreq = max(maxFreq, sumFreq[currSum]);
        
        // Iterate on left and right subtrees and find their sums.
        preOrderTraversal(root -> left, sumFreq, maxFreq);
        preOrderTraversal(root -> right, sumFreq, maxFreq);
    }
    
    vector<int> findFrequentTreeSum(TreeNode* root) {
        unordered_map<int, int> sumFreq;
        int maxFreq = 0;
        
        // Traverse on all nodes one by one, and find it's tree's sum.
        preOrderTraversal(root, sumFreq, maxFreq);
        
        vector<int> maxFreqSums;
        for(auto& it : sumFreq) {
            if (it.second == maxFreq) {
                maxFreqSums.push_back(it.first);
            }
        }
        
        return maxFreqSums;
    }
};