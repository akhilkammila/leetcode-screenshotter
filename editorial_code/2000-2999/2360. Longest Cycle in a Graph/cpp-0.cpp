class Solution {
public:
    int answer = -1;

    void dfs(int node, vector<int>& edges, unordered_map<int, int>& dist, vector<bool>& visit) {
        visit[node] = true;
        int neighbor = edges[node];

        if (neighbor != -1 && !visit[neighbor]) {
            dist[neighbor] = dist[node] + 1;
            dfs(neighbor, edges, dist, visit);
        } else if (neighbor != -1 && dist.count(neighbor)) {
            answer = max(answer, dist[node] - dist[neighbor] + 1);
        }
    }

    int longestCycle(vector<int>& edges) {
        int n = edges.size();
        vector<bool> visit(n);

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                unordered_map<int, int> dist;
                dist[i] = 1;
                dfs(i, edges, dist, visit);
            }
        }
        return answer;
    }
};