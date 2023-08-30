class Solution {
public:
    bool validPath(int n, vector<vector<int>>& edges, int source, int destination) {
        // Store all edges in 'graph'.
        unordered_map<int, vector<int>> graph;
        for (auto& edge : edges) {
            int a = edge[0], b = edge[1];
            graph[a].push_back(b);
            graph[b].push_back(a);
        }
        
        // Store all the nodes to be visited in 'bfsQueue'.
        // NOTE: 'queue' conflicts with the type name std::queue, 
        // so we use 'bfsQueue' instead.
        vector<bool> seen(n);
        seen[source] = true;
        queue<int> bfsQueue;
        bfsQueue.push(source);
        
        while (!bfsQueue.empty()) {
            int currNode = bfsQueue.front();
            bfsQueue.pop();
            if (currNode == destination) {
                return true;
            }

            // For all the neighbors of the current node, if we haven't visit it before,
            // add it to 'bfsQueue' and mark it as visited.
            for (auto& nextNode : graph[currNode]) {
                if (!seen[nextNode]) {
                    seen[nextNode] = true;
                    bfsQueue.push(nextNode);
                }
            }
        }
        
        return false;
    }
};