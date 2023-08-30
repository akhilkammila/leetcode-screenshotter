class Solution {
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
        
        // Use stack 'stack' to store all nodes to be visited, start from node 0.
        int ans = 0;
        seen.add(0);
        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        
        while (!stack.isEmpty()) {
            int currNode = stack.pop();
            ans++;
            
            // Add all unvisited neighbors of the current node to 'stack' 
            // and mark it as visited.
            for (int nextNode : neighbors.get(currNode)) {
                if (!seen.contains(nextNode)) {
                    seen.add(nextNode);
                    stack.add(nextNode);
                }
            }
        }
        
        return ans;
    }
}