class Solution {
public:
    int secondMinimum(int n, vector<vector<int>>& edges, int time, int change) {
        vector<vector<int>> adj(n + 1);
        for (auto& edge: edges) {
            adj[edge[0]].push_back(edge[1]);
            adj[edge[1]].push_back(edge[0]);
        }

        // dist1[i] stores the minimum time taken to reach node i from node 1. dist2[i] stores the
        // second minimum time taken to reach node from node 1. freq[i] stores the number of times a
        // node is popped out of the heap.
        vector<int> dist1(n + 1, numeric_limits<int>::max()),
            dist2(n + 1, numeric_limits<int>::max()), freq(n + 1);
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> min_heap;
        min_heap.push({0, 1});
        dist1[1] = 0;

        while (!min_heap.empty()) {
            auto [timeTaken, node] = min_heap.top();
            min_heap.pop();

            freq[node]++;
            // If the node is being visited for the second time and is 'n', return the answer.
            if (freq[node] == 2 && node == n) return timeTaken;
            // If the current light is red, wait till the path turns green.
            if ((timeTaken / change) % 2) {
                timeTaken = change * (timeTaken / change + 1) + time;
            } else {
                timeTaken = timeTaken + time;
            }

            for (auto& neighbor: adj[node]) {
                // Ignore nodes that have already popped out twice.
                if (freq[neighbor] == 2) continue;
                // Update dist1 if it's more than the current timeTaken and store its value in
                // dist2 since that becomes the second minimum value now.
                if (dist1[neighbor] > timeTaken) {
                    dist2[neighbor] = dist1[neighbor];
                    dist1[neighbor] = timeTaken;
                    min_heap.push({timeTaken, neighbor});
                } else if (dist2[neighbor] > timeTaken && dist1[neighbor] != timeTaken) {
                    dist2[neighbor] = timeTaken;
                    min_heap.push({timeTaken, neighbor});
                }
            }
        }
        return 0;
    }
};