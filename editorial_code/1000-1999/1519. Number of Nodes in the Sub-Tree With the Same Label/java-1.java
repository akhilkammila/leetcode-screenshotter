class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            adj.computeIfAbsent(a, value -> new HashSet<Integer>()).add(b);
            adj.computeIfAbsent(b, value -> new HashSet<Integer>()).add(a);
        }
        // Store count of all alphabets of subtree of each node.
        int[][] counts = new int[n][26];
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            counts[i][labels.charAt(i) - 'a'] = 1;
            if (i != 0 && adj.get(i).size() == 1) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int node = q.poll();

            // Each node will have only one element which will be its parent.
            int parent = adj.get(node).stream().findFirst().get();
            // Remove current node from adjency list of parent node
            // so current node is not traversed again by parent node.
            // (due to this step, we remove all child nodes from a parent, at end parent node will only have its parent in adjacency list)
            adj.get(parent).remove(node);

            // Add counts of current node in parent's frequency array.
            for (int i = 0; i < 26; i++) {
                counts[parent][i] += counts[node][i];
            }

            // If parent adj size is 1, it has only it's parent in the adjacency list so,
            // it means current node is last child of parent so we insert it in queue now.
            if (parent != 0 && adj.get(parent).size() == 1) {
                q.offer(parent);
            }
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = counts[i][labels.charAt(i) - 'a'];
        }
        return ans;
    }
}