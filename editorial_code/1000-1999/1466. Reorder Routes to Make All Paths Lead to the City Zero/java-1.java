class Solution {
    int count = 0;

    public void bfs(int node, int n, Map<Integer, List<List<Integer>>> adj) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visit = new boolean[n];
        q.offer(node);
        visit[node] = true;

        while (!q.isEmpty()) {
            node = q.poll();
            if (!adj.containsKey(node)) {
                continue;
            }
            for (List<Integer> nei : adj.get(node)) {
                int neighbor = nei.get(0);
                int sign = nei.get(1);
                if (!visit[neighbor]) {
                    count += sign;
                    visit[neighbor] = true;
                    q.offer(neighbor);
                }
            }
        }
    }

    public int minReorder(int n, int[][] connections) {
        Map<Integer, List<List<Integer>>> adj = new HashMap<>();
        for (int[] connection : connections) {
            adj.computeIfAbsent(connection[0], k -> new ArrayList<List<Integer>>()).add(
                    Arrays.asList(connection[1], 1));
            adj.computeIfAbsent(connection[1], k -> new ArrayList<List<Integer>>()).add(
                    Arrays.asList(connection[0], 0));
        }
        bfs(0, n, adj);
        return count;
    }
}