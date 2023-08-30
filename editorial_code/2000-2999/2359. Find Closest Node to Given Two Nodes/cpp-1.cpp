class Solution {
public:
    void dfs(int node, vector<int>& edges, vector<int>& dist, vector<bool>& visit) {
        visit[node] = true;
        int neighbor = edges[node];
        if (neighbor != -1 && !visit[neighbor]) {
            dist[neighbor] = 1 + dist[node];
            dfs(neighbor, edges, dist, visit);
        }
    }

    int closestMeetingNode(vector<int>& edges, int node1, int node2) {
        int n = edges.size();
        vector<int> dist1(n, numeric_limits<int>::max()), dist2(n, numeric_limits<int>::max());
        vector<bool> visit1(n), visit2(n);
        dist1[node1] = 0, dist2[node2] = 0;

        dfs(node1, edges, dist1, visit1);
        dfs(node2, edges, dist2, visit2);

        int minDistNode = -1, minDistTillNow = numeric_limits<int>::max();
        for (int currNode = 0; currNode < n; currNode++) {
            if (minDistTillNow > max(dist1[currNode], dist2[currNode])) {
                minDistNode = currNode;
                minDistTillNow = max(dist1[currNode], dist2[currNode]);
            }
        }

        return minDistNode;
    }
};