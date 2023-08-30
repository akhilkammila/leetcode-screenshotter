class Solution {
public:
    vector<int> dfs(int node, int parent, vector<vector<int>>& adj, string& labels,
                    vector<int>& ans) {
        // Store count of all alphabets in the subtree of the node.
        vector<int> nodeCounts(26);
        nodeCounts[labels[node] - 'a'] = 1;

        for (auto& child : adj[node]) {
            if (child == parent) {
                continue;
            }
            vector<int> childCounts = dfs(child, node, adj, labels, ans);
            // Add frequencies of the child node in the parent node's frequency array.
            for (int i = 0; i < 26; i++) {
                nodeCounts[i] += childCounts[i];
            }
        }

        ans[node] = nodeCounts[labels[node] - 'a'];
        return nodeCounts;
    }

    vector<int> countSubTrees(int n, vector<vector<int>>& edges, string labels) {
        vector<vector<int>> adj(n);
        for (auto& edge : edges) {
            adj[edge[0]].push_back(edge[1]);
            adj[edge[1]].push_back(edge[0]);
        }

        vector<int> ans(n, 0);
        dfs(0, -1, adj, labels, ans);

        return ans;
    }
};