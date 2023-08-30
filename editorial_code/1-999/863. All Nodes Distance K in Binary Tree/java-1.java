class Solution {
    Map<Integer, List<Integer>> graph;
    List<Integer> answer;
    Set<Integer> visited;
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        graph = new HashMap<>();
        buildGraph(root, null);
        
        answer = new ArrayList<>();
        visited = new HashSet<>();
        visited.add(target.val);
        
        dfs(target.val, 0, k);
        
        return answer;
    }
    
    // Recursively build the undirected graph from the given binary tree.
    private void buildGraph(TreeNode cur, TreeNode parent) {
        if (cur != null && parent != null) {
            graph.computeIfAbsent(cur.val, k -> new ArrayList<>()).add(parent.val);
            graph.computeIfAbsent(parent.val, k -> new ArrayList<>()).add(cur.val);
        }
        if (cur.left != null) {
            buildGraph(cur.left, cur);
        }
        if (cur.right != null) {
            buildGraph(cur.right, cur);
        }
    }
    
    private void dfs(int cur, int distance, int k) {
        if (distance == k) {
            answer.add(cur);
            return;
        }
        for (int neighbor : graph.getOrDefault(cur, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                visited.add(neighbor);
                dfs(neighbor, distance + 1, k);
            }
        }
    }
}