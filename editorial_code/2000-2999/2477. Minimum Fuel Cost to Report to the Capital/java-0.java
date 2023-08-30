class Solution {
    long fuel;

    public long dfs(int node, int parent, Map<Integer, List<Integer>> adj, int seats) {
        // The node itself has one representative.
        int representatives = 1;
        if (!adj.containsKey(node)) {
            return representatives;
        }
        for (int child : adj.get(node)) {
            if (child != parent) {
                // Add count of representatives in each child subtree to the parent subtree.
                representatives += dfs(child, node, adj, seats);
            }
        }
        if (node != 0) {
            // Count the fuel it takes to move to the parent node.
            // Root node does not have any parent so we ignore it.
            fuel += Math.ceil((double) representatives / seats);
        }
        return representatives;
    }

    public long minimumFuelCost(int[][] roads, int seats) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] road : roads) {
            adj.computeIfAbsent(road[0], k -> new ArrayList<Integer>()).add(road[1]);
            adj.computeIfAbsent(road[1], k -> new ArrayList<Integer>()).add(road[0]);
        }
        dfs(0, -1, adj, seats);
        return fuel;
    }
}