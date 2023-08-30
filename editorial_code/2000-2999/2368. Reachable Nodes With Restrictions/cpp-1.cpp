class Solution {
public:
    void dfs(int currNode, int& ans, vector<vector<int>>& neighbors, vector<bool>& seen) {
        // Mark 'currNode' as visited and increment 'ans' by 1.
        ans++;
        seen[currNode] = true;
        
        // Go for unvisited neighbors of 'currNode'.
        for (auto nextNode : neighbors[currNode]) {
            if (!seen[nextNode]) {
                dfs(nextNode, ans, neighbors, seen);
            }
        }
    }
    
    int reachableNodes(int n, vector<vector<int>>& edges, vector<int>& restricted) {
        //Store all edges according to nodes in 'neighbors'.
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
        
        int ans = 0;
        dfs(0, ans, neighbors, seen);
        return ans;
    }
};