class Solution {
public:
    // Adjacency list, defined it as per the maximum number of nodes
    // But can be defined with the input size as well
    vector<pair<int, int>> adj[101];
    
    void dijkstra(vector<int>& signalReceivedAt, int source, int n) {
        priority_queue<pair<int, int>, vector<pair<int, int>>, 
        greater<pair<int, int>>> pq;
        pq.push({0, source});
        
        // Time for starting node is 0
        signalReceivedAt[source] = 0;
        
        while (!pq.empty()) {
            int currNodeTime = pq.top().first;
            int currNode = pq.top().second; 
            pq.pop();
            
            if (currNodeTime > signalReceivedAt[currNode]) {
                continue;
            }
            
            // Broadcast the signal to adjacent nodes
            for (pair<int, int> edge : adj[currNode]) {
                int time = edge.first;
                int neighborNode = edge.second;
                
                // Fastest signal time for neighborNode so far
                // signalReceivedAt[currNode] + time : 
                // time when signal reaches neighborNode
                if (signalReceivedAt[neighborNode] > currNodeTime + time) {
                    signalReceivedAt[neighborNode] = currNodeTime + time;
                    pq.push({signalReceivedAt[neighborNode], neighborNode});
                }
            }
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
        
        vector<int> signalReceivedAt(n + 1, INT_MAX);
        dijkstra(signalReceivedAt, k, n);
        
        int answer = INT_MIN;
        for (int i = 1; i <= n; i++) {
            answer = max(answer, signalReceivedAt[i]);
        }
        
        // INT_MAX signifies atleat one node is unreachable
        return answer == INT_MAX ? -1 : answer;
    }
};