class Solution {
    public void bfs(int node, Map<Integer, List<Integer>> adj, boolean[] visit) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        visit[node] = true;

        while (!q.isEmpty()) {
            node = q.poll();
            if (!adj.containsKey(node)) {
                continue;
            }
            for (int neighbor : adj.get(node)) {
                if (!visit[neighbor]) {
                    visit[neighbor] = true;
                    q.offer(neighbor);
                }
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
                bfs(i, adj, visit);
            }
        }

        return numberOfConnectedComponents - 1;
    }
}