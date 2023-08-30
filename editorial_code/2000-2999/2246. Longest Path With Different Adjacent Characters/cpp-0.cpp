class Solution {
public:
    int dfs(int currentNode, vector<vector<int>>& children, string& s, int& longestPath) {
        // Longest and second longest chains starting from currentNode (does not count the
        // currentNode itself).
        int longestChain = 0, secondLongestChain = 0;
        for (int child : children[currentNode]) {
            // Get the number of nodes in the longest path in the subtree of child,
            // including the child.
            int longestChainStartingFromChild = dfs(child, children, s, longestPath);
            // We won't move to the child if it has the same character as the currentNode.
            if (s[currentNode] == s[child]) {
                continue;
            }
            // Modify the longestChain and secondLongestChain if longestChainStartingFromChild
            // is bigger.
            if (longestChainStartingFromChild > longestChain) {
                secondLongestChain = longestChain;
                longestChain = longestChainStartingFromChild;
            } else if (longestChainStartingFromChild > secondLongestChain) {
                secondLongestChain = longestChainStartingFromChild;
            }
        }

        // Add "1" for the node itself.
        longestPath = max(longestPath, longestChain + secondLongestChain + 1);
        return longestChain + 1;
    }

    int longestPath(vector<int>& parent, string s) {
        int n = parent.size();
        vector<vector<int>> children(n);
        // Start from node 1, since root node 0 does not have a parent.
        for (int i = 1; i < n; i++) {
            children[parent[i]].push_back(i);
        }

        int longestPath = 1;
        dfs(0, children, s, longestPath);

        return longestPath;
    }
};