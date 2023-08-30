class Solution {
public:
    bool validPath(int n, vector<vector<int>>& edges, int source, int destination) {
        // Store all edges according to nodes in 'graph'.
        unordered_map<int, vector<int>> graph;
        for (auto& edge : edges) {
            int a = edge[0], b = edge[1];
            graph[a].push_back(b);
            graph[b].push_back(a);
        }
        
        // Start from source node, add it to stack.
        // NOTE: 'stack' conflicts with the type name std::stack, 
        // so we use 'dfsStack' instead.
        vector<bool> seen(n);
        stack<int> dfsStack({source});
        seen[source] = true;
        
        while (!dfsStack.empty()) {
            int currNode = dfsStack.top();
            dfsStack.pop();
            
            if (currNode == destination) {
                return true;
            }
            
            // Add all unvisited neighbors of the current node to 'dfsStack' 
            // and mark them as visited.
            for (auto nextNode : graph[currNode]) {
                if (!seen[nextNode]) {
                    seen[nextNode] = true;
                    dfsStack.push(nextNode);
                }
            }
        }
        
        return false;
    }
};