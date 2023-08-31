class Solution {
public:
    int subtreeSum(TreeNode* root, unordered_map<int, int>& sumFreq, int& maxFreq) {
        if (!root) {
            return 0;
        }
        
        // Get left and right subtree's sum.
        int leftSubtreeSum = subtreeSum(root -> left, sumFreq, maxFreq);
        int rightSubtreeSum = subtreeSum(root -> right, sumFreq, maxFreq);
        
        // Use the sum of subtrees to get the sum of the current tree.
        int currSum = root -> val + leftSubtreeSum + rightSubtreeSum;
        
        sumFreq[currSum]++;
        maxFreq = max(maxFreq, sumFreq[currSum]);
        return currSum;
    }
    
    vector<int> findFrequentTreeSum(TreeNode* root) {
        unordered_map<int, int> sumFreq;
        int maxFreq = 0;
        
        // Traverse on all nodes one by one, and find it's tree's sum.
        subtreeSum(root, sumFreq, maxFreq);
        
        vector<int> maxFreqSums;
        for(auto& it : sumFreq) {
            if (it.second == maxFreq) {
                maxFreqSums.push_back(it.first);
            }
        }
        
        return maxFreqSums;
    }
};