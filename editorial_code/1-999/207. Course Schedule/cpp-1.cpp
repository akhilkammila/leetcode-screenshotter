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

    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        vector<vector<int>> adj(numCourses);
        for (auto prerequisite : prerequisites) {
            adj[prerequisite[1]].push_back(prerequisite[0]);
        }

        vector<bool> visit(numCourses);
        vector<bool> inStack(numCourses);
        for (int i = 0; i < numCourses; i++) {
            if (dfs(i, adj, visit, inStack)) {
                return false;
            }
        }
        return true;
    }
};