class Solution {
public:
    int reachableNodes(int n, vector<vector<int>>& edges, vector<int>& restricted) {
        // Store all edges according to nodes in 'neighbors'.
        vector<vector<int>> neighbors(n);
        for (auto edge : edges) {
            int nodeA = edge[0], nodeB = edge[1];
            neighbors[nodeA].push_back(nodeB);
            neighbors[nodeB].push_back(nodeA);
        }
        
        // Mark the nodes in 'restricted' as visited.
        vector<bool> seen(n, false);
        for (auto node : restricted) {
            seen[node] = true;
        }
        
        // Use a stack 'stack' to store all the nodes to be visited, start from node 0.
        int ans = 0;
        stack<int> stack({0});

        seen[0] = true;

        while (!stack.empty()) {
            int currNode = stack.top();
            stack.pop();
            ans++;
            
            // Add all unvisited neighbors of the current node to 'stack' 
            // and mark them as visited.
            for (auto nextNode : neighbors[currNode]) {
                if (!seen[nextNode]) {
                    seen[nextNode] = true;
                    stack.push(nextNode);
                }
            }
        }
        
        return ans;    
    }
};