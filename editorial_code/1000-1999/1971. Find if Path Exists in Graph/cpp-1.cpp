class Solution {
public:
    bool dfs(unordered_map<int, vector<int>>& graph, vector<bool>& seen, int currNode, int destination) {
        if (currNode == destination) {
            return true;
        }
        if (!seen[currNode]) {
            seen[currNode] = true;
            for (auto& nextNode : graph[currNode]) {
                if (dfs(graph, seen, nextNode, destination)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    bool validPath(int n, vector<vector<int>>& edges, int source, int destination) {
        unordered_map<int, vector<int>> graph;
        for (auto& edge : edges) {
            int a = edge[0], b = edge[1];
            graph[a].push_back(b);
            graph[b].push_back(a);
        }

        vector<bool> seen(n);
        return dfs(graph, seen, source, destination);
    }
};