class Solution {
public:
    int longestPath(vector<int>& parent, string s) {
        int n = parent.size();
        vector<int> childrenCount(n);
        // Start from 1, since the root node does not have a parent.
        for (int node = 1; node < n; node++) {
            childrenCount[parent[node]]++;
        }

        vector<vector<int>> longestChains(n);
        queue<int> q;
        int longestPath = 1;

        for (int node = 0; node < n; node++) {
            longestChains[node] = vector<int>(2);
            // Push all leaf nodes in the queue.
            if (childrenCount[node] == 0 && node != 0) {
                q.push(node);
                longestChains[node][0] = 1;
            }
        }

        while (!q.empty()) {
            int currentNode = q.front();
            q.pop();
            int par = parent[currentNode];

            // Get the number of nodes in the longest chain starting from the currentNode,
            // including the currentNode.
            int longestChainStartingFromCurrNode = longestChains[currentNode][0];
            if (s[currentNode] != s[par]) {
                // Modify the longest chain and second longest chain if
                // longestChainStartingFromCurrNode is bigger.
                int longestChainStartingFromCurrNode = longestChains[currentNode][0];
                if (longestChainStartingFromCurrNode > longestChains[par][0]) {
                    longestChains[par][1] = longestChains[par][0];
                    longestChains[par][0] = longestChainStartingFromCurrNode;
                } else if (longestChainStartingFromCurrNode > longestChains[par][1]) {
                    longestChains[par][1] = longestChainStartingFromCurrNode;
                }
            }

            longestPath = max(longestPath, longestChains[par][0] + longestChains[par][1] + 1);
            childrenCount[par]--;

            if (childrenCount[par] == 0 && par != 0) {
                longestChains[par][0]++;
                q.push(par);
            }
        }

        return longestPath;
    }
};