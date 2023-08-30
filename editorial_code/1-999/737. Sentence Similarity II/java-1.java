class Solution {
    // Returns true if there is a path from node to dest.
    boolean bfs(String source, Map<String, HashSet<String>> adj, String dest) {
        Set<String> visit = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.offer(source);
        visit.add(source);

        while (!q.isEmpty()) {
            String node = q.poll();

            if (!adj.containsKey(node)) {
                continue;
            }
            for (String neighbor : adj.get(node)) {
                if (neighbor.equals(dest)) {
                    return true;
                }
                if (!visit.contains(neighbor)) {
                    visit.add(neighbor);
                    q.offer(neighbor);
                }
            }
        }
        return false;
    }

    public boolean areSentencesSimilarTwo(String[] sentence1, String[] sentence2,
            List<List<String>> similarPairs) {
        if (sentence1.length != sentence2.length) {
            return false;
        }
        // Create the graph using each pair in similarPairs.
        Map<String, HashSet<String>> adj = new HashMap<>();
        for (List<String> pair : similarPairs) {
            adj.computeIfAbsent(pair.get(0), value -> new HashSet<String>()).add(pair.get(1));
            adj.computeIfAbsent(pair.get(1), value -> new HashSet<String>()).add(pair.get(0));
        }

        for (int i = 0; i < sentence1.length; i++) {
            if (sentence1[i].equals(sentence2[i])) {
                continue;
            }
            if (adj.containsKey(sentence1[i]) && adj.containsKey(sentence2[i]) &&
                    bfs(sentence1[i], adj, sentence2[i])) {
                continue;
            }
            return false;
        }
        return true;
    }
}