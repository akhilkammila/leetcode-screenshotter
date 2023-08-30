class Solution {
    private int dfs(int node, String colors, Map<Integer, List<Integer>> adj, int[][] count,
            boolean[] visit, boolean[] inStack) {
        // If the node is already in the stack, we have a cycle.
        if (inStack[node]) {
            return Integer.MAX_VALUE;
        }
        if (visit[node]) {
            return count[node][colors.charAt(node) - 'a'];
        }
        // Mark the current node as visited and part of current recursion stack.
        visit[node] = true;
        inStack[node] = true;

        if (adj.containsKey(node)) {
            for (int neighbor : adj.get(node)) {
                if (dfs(neighbor, colors, adj, count, visit, inStack) == Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                for (int i = 0; i < 26; i++) {
                    count[node][i] = Math.max(count[node][i], count[neighbor][i]);
                }
            }
        }

        // After all the incoming edges to the node are processed,
        // we count the color on the node itself.
        count[node][colors.charAt(node) - 'a']++;
        // Remove the node from the stack.
        inStack[node] = false;
        return count[node][colors.charAt(node) - 'a'];
    }

    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        Map<Integer, List<Integer>> adj = new HashMap<>();

        for (int[] edge : edges) {
            adj.computeIfAbsent(edge[0], k->new ArrayList<Integer>()).add(edge[1]);
        }

        int[][] count = new int[n][26];
        boolean[] visit = new boolean[n];
        boolean[] inStack = new boolean[n];
        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, dfs(i, colors, adj, count, visit, inStack));
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}