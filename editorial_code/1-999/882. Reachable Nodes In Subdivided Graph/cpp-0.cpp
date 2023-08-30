#define pii pair<int, int>

class Solution {
public:
    int reachableNodes(vector<vector<int>>& edges, int M, int N) {
        vector<vector<pii>> graph(N);
        for (vector<int> edge: edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            graph[u].push_back({v, w});
            graph[v].push_back({u, w});
        }

        map<int, int> dist;
        dist[0] = 0;
        for (int i = 1; i < N; ++i)
            dist[i] = M+1;

        map<pii, int> used;
        int ans = 0;

        priority_queue<pii, vector<pii>, greater<pii>> pq;
        pq.push({0, 0});

        while (!pq.empty()) {
            pii top = pq.top();
            pq.pop();
            int d = top.first, node = top.second;
            if (d > dist[node]) continue;

            // Each node is only visited once.  We've reached
            // a node in our original graph.
            ans++;

            for (auto pair: graph[node]) {
                // M - d is how much further we can walk from this node;
                // weight is how many new nodes there are on this edge.
                // v is the maximum utilization of this edge.
                int nei = pair.first;
                int weight = pair.second;
                used[{node, nei}] = min(weight, M - d);

                // d2 is the total distance to reach 'nei' (neighbor) node
                // in the original graph.
                int d2 = d + weight + 1;
                if (d2 < min(dist[nei], M+1)) {
                    pq.push({d2, nei});
                    dist[nei] = d2;
                }
            }
        }

        // At the end, each edge (u, v, w) can be used with a maximum
        // of w new nodes: a max of used[u, v] nodes from one side,
        // and used[v, u] nodes from the other.
        for (vector<int> edge: edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            ans += min(w, used[{u, v}] + used[{v, u}]);
        }
        return ans;
    }
};