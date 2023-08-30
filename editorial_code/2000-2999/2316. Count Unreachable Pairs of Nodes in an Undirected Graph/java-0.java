class Solution {
    public int dfs(int node, Map<Integer, List<Integer>> adj, boolean[] visit) {
        int count = 1;
        visit[node] = true;
        if (!adj.containsKey(node)) {
            return count;
        }
        for (int neighbor : adj.get(node)) {
            if (!visit[neighbor]) {
                count += dfs(neighbor, adj, visit);
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
                sizeOfComponent = dfs(i, adj, visit);
                numberOfPairs += sizeOfComponent * (remainingNodes - sizeOfComponent);
                remainingNodes -= sizeOfComponent;
            }
        }
        return numberOfPairs;
    }
}