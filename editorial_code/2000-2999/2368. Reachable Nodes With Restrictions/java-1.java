class Solution {
    private int ans = 0;
    private void dfs(int currNode, Map<Integer, List<Integer>> neighbors, Set<Integer> seen) {
        // Mark 'currNode' as visited and increment 'ans' by 1.
        ans++;
        seen.add(currNode);
        
        // Go for unvisited neighbors of 'currNode'.
        for (int nextNode : neighbors.get(currNode)) {
            if (!seen.contains(nextNode)) {
                dfs(nextNode, neighbors, seen);
            }
        }    
    }
    
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        //Store all edges according to nodes in 'neighbors'.
        Map<Integer, List<Integer>> neighbors = new HashMap<>();
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            neighbors.computeIfAbsent(a, value -> new ArrayList<Integer>()).add(b);
            neighbors.computeIfAbsent(b, value -> new ArrayList<Integer>()).add(a);
        }
        
        // Mark the nodes in 'restricted' as visited.
        Set<Integer> seen = new HashSet<>();
        for (int node : restricted) {
            seen.add(node);
        }
        
        dfs(0, neighbors, seen);
        return ans;
    }
}