class Solution {
public:
    int reachableNodes(int n, vector<vector<int>>& edges, vector<int>& restricted) {
        // Store all edges in 'neighbors'.
        vector<vector<int>> neighbors(n);
        for (auto& edge : edges) {
            int nodeA = edge[0], nodeB = edge[1];
            neighbors[nodeA].push_back(nodeB);
            neighbors[nodeB].push_back(nodeA);
        }
        
        // Mark the nodes in 'restricted' as visited.
        vector<bool> seen(n);
        for (int node : restricted) {
            seen[node] = true;
        }
        
        // Store all the nodes to be visited in 'bfsQueue'.
        // NOTE: 'queue' conflicts with the type name std::queue, 
        // so we use 'bfsQueue' instead.
        int ans = 0;
        queue<int> bfsQueue({0});

        seen[0] = true;

        while (!bfsQueue.empty()) {
            int currNode = bfsQueue.front();
            bfsQueue.pop();
            ans++;
            
            // For all the neighbors of the current node, if we haven't visit it before,
            // add it to 'bfsQueue' and mark it as visited.
            for (auto nextNode : neighbors[currNode]) {
                if (!seen[nextNode]) {
                    seen[nextNode] = true;
                    bfsQueue.push(nextNode);
                }
            }
        }
        
        return ans;    
    }
};