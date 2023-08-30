class Solution {
public:
    // Adjacency list, defined it as per the maximum number of nodes
    // But can be defined with the input size as well
    vector<pair<int, int>> adj[101];
    
    void DFS(vector<int>& signalReceivedAt, int currNode, int currTime) {
        // If the current time is greater than or equal to the fastest signal received
        // Then no need to iterate over adjacent nodes
        if (currTime >= signalReceivedAt[currNode]) {
            return;
        }

        // Fastest signal time for currNode so far
        signalReceivedAt[currNode] = currTime;
        
        // Broadcast the signal to adjacent nodes
        for (pair<int, int> edge : adj[currNode]) {
            int travelTime = edge.first;
            int neighborNode = edge.second;
            
            // currTime + time : time when signal reaches neighborNode
            DFS(signalReceivedAt, neighborNode, currTime + travelTime);
        }
    }
    
    int networkDelayTime(vector<vector<int>>& times, int n, int k) {
        // Build the adjacency list
        for (vector<int> time : times) {
            int source = time[0];
            int dest = time[1];
            int travelTime = time[2];
            
            adj[source].push_back({travelTime, dest});
        }
        
        // Sort the edges connecting to every node
        for (int i = 1; i <= n; i++) {
            sort(adj[i].begin(), adj[i].end());
        }
        
        vector<int> signalReceivedAt(n + 1, INT_MAX);
        DFS(signalReceivedAt, k, 0);
        
        int answer = INT_MIN;
        for (int node = 1; node <= n; node++) {
            answer = max(answer, signalReceivedAt[node]);
        }
        
        // INT_MAX signifies atleat one node is unreachable
        return answer == INT_MAX ? -1 : answer;
    }
};