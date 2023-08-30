class Solution {
public:
    bool dfs(int node, vector<vector<int>>& adj, vector<bool>& visit, vector<bool>& inStack) {
        // If the node is already in the stack, we have a cycle.
        if (inStack[node]) {
            return true;
        }
        if (visit[node]) {
            return false;
        }
        // Mark the current node as visited and part of current recursion stack.
        visit[node] = true;
        inStack[node] = true;
        for (auto neighbor : adj[node]) {
            if (dfs(neighbor, adj, visit, inStack)) {
                return true;
            }
        }
        // Remove the node from the stack.
        inStack[node] = false;
        return false;
    }

    vector<int> eventualSafeNodes(vector<vector<int>>& graph) {
        int n = graph.size();
        vector<bool> visit(n), inStack(n);

        for (int i = 0; i < n; i++) {
            dfs(i, graph, visit, inStack);
        }

        vector<int> safeNodes;
        for (int i = 0; i < n; i++) {
            if (!inStack[i]) {
                safeNodes.push_back(i);
            }
        }

        return safeNodes;
    }
};