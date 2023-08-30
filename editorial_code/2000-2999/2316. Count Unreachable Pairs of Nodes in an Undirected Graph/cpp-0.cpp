class Solution {
public:
    int dfs(int node, vector<vector<int>>& adj, vector<bool>& visit) {
        int count = 1;
        visit[node] = true;
        for (int neighbor : adj[node]) {
            if (!visit[neighbor]) {
                count += dfs(neighbor, adj, visit);
            }
        }
        return count;
    }

    long long countPairs(int n, vector<vector<int>>& edges) {
        vector<vector<int>> adj(n);
        for (auto edge : edges) {
            adj[edge[0]].push_back(edge[1]);
            adj[edge[1]].push_back(edge[0]);
        }

        long long numberOfPairs = 0;
        long long sizeOfComponent = 0;
        long long remainingNodes = n;
        vector<bool> visit(n);
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                sizeOfComponent = dfs(i, adj, visit);
                numberOfPairs += sizeOfComponent * (remainingNodes - sizeOfComponent);
                remainingNodes -= sizeOfComponent;
            }
        }
        return numberOfPairs;
    }
};