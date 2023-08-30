class Solution {
    public void dfs(int node, Map<Integer, List<Integer>> adj, boolean[] visit) {
        visit[node] = true;
        if (!adj.containsKey(node)) {
            return;
        }
        for (int neighbor : adj.get(node)) {
            if (!visit[neighbor]) {
                visit[neighbor] = true;
                dfs(neighbor, adj, visit);
            }
        }
    }

    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }

        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] connection : connections) {
            adj.computeIfAbsent(connection[0], k -> new ArrayList<Integer>()).add(connection[1]);
            adj.computeIfAbsent(connection[1], k -> new ArrayList<Integer>()).add(connection[0]);
        }

        int numberOfConnectedComponents = 0;
        boolean[] visit = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                numberOfConnectedComponents++;
                dfs(i, adj, visit);
            }
        }

        return numberOfConnectedComponents - 1;
    }
}