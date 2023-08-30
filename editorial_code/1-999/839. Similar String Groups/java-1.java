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

    public boolean isSimilar(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
            }
        }
        return diff == 0 || diff == 2;
    }

    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        Map<Integer, List<Integer>> adj = new HashMap<>();
        // Form the required graph from the given strings array.
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isSimilar(strs[i], strs[j])) {
                    adj.computeIfAbsent(i, k -> new ArrayList<Integer>()).add(j);
                    adj.computeIfAbsent(j, k -> new ArrayList<Integer>()).add(i);
                }
            }
        }

        boolean[] visit = new boolean[n];
        int count = 0;
        // Count the number of connected components.
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                bfs(i, adj, visit);
                count++;
            }
        }

        return count;
    }
}