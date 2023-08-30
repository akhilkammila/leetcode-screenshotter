class Solution {
    public int bfs(int node, Map<Integer, List<Integer>> adj, boolean[] visit) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        int count = 1;
        visit[node] = true;

        while (!q.isEmpty()) {
            node = q.poll();
            if (!adj.containsKey(node)) {
                continue;
            }
            for (int neighbor : adj.get(node)) {
                if (!visit[neighbor]) {
                    visit[neighbor] = true;
                    count++;
                    q.offer(neighbor);
                }
            }
        }
        return count;
    }

    public long countPairs(int n, int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] edge : edges) {
            adj.computeIfAbsent(edge[0], k -> new ArrayList<Integer>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], k -> new ArrayList<Integer>()).add(edge[0]);
        }

        long numberOfPairs = 0;
        long sizeOfComponent = 0;
        long remainingNodes = n;
        boolean[] visit = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                sizeOfComponent = bfs(i, adj, visit);
                numberOfPairs += sizeOfComponent * (remainingNodes - sizeOfComponent);
                remainingNodes -= sizeOfComponent;
            }
        }
        return numberOfPairs;
    }
}