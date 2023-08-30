class Solution {
public:
    long long fuel;

    long long dfs(int node, int parent, vector<vector<int>>& adj, int& seats) {
        // The node itself has one representative.
        int representatives = 1;
        for (auto& child : adj[node]) {
            if (child != parent) {
                // Add count of representatives in each child subtree to the parent subtree.
                representatives += dfs(child, node, adj, seats);
            }
        }

        if (node != 0) {
            // Count the fuel it takes to move to the parent node.
            // Root node does not have any parent so we ignore it.
            fuel += ceil((double)representatives / seats);
        }
        return representatives;
    }

    long long minimumFuelCost(vector<vector<int>>& roads, int seats) {
        int n = roads.size() + 1;
        vector<vector<int>> adj(n);
        for (auto& road : roads) {
            adj[road[0]].push_back(road[1]);
            adj[road[1]].push_back(road[0]);
        }
        dfs(0, -1, adj, seats);
        return fuel;
    }
};