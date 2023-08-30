class Solution {
public:
    void dfs(int node, vector<vector<pair<int, int>>>& adj, vector<bool>& visit, int& answer) {
        visit[node] = true;
        for (auto& edge : adj[node]) {
            answer = min(answer, edge.second);
            if (!visit[edge.first]) {
                dfs(edge.first, adj, visit, answer);
            }
        }
    }

    int minScore(int n, vector<vector<int>>& roads) {
        vector<vector<pair<int, int>>> adj(n + 1);
        for (auto& road : roads) {
            adj[road[0]].push_back({road[1], road[2]});
            adj[road[1]].push_back({road[0], road[2]});
        }

        vector<bool> visit(n + 1);
        int answer = numeric_limits<int>::max();
        dfs(1, adj, visit, answer);

        return answer;
    }
};