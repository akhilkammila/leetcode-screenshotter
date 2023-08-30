class Solution {
    // Returns true if there is a path from node to dest.
    boolean dfs(String node, Map<String, HashSet<String>> adj, Set<String> visit, String dest) {
        visit.add(node);
        if (node.equals(dest)) {
            return true;
        }
        if (!adj.containsKey(node)) {
            return false;
        }
        for (String neighbor : adj.get(node)) {
            if (!visit.contains(neighbor) && dfs(neighbor, adj, visit, dest)) {
                return true;
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
            Set<String> visit = new HashSet<>();
            if (adj.containsKey(sentence1[i]) && adj.containsKey(sentence2[i]) &&
                    dfs(sentence1[i], adj, visit, sentence2[i])) {
                continue;
            }
            return false;
        }
        return true;
    }
}