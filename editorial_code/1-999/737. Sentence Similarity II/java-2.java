class UnionFind {
    Map<String, String> parent = new HashMap<>();
    Map<String, Integer> rank = new HashMap<>();

    public void addWord(String x) {
        if (!parent.containsKey(x)) {
            parent.put(x, x);
            rank.put(x, 0);
        }
    }

    public boolean isWordPresent(String x) {
        if (parent.containsKey(x)) {
            return true;
        }
        return false;
    }

    public String find(String x) {
        if (parent.get(x) != x)
            parent.put(x, find(parent.get(x)));
        return parent.get(x);
    }

    public void union(String x, String y) {
        String xset = find(x), yset = find(y);
        if (xset == yset) {
            return;
        } else if (rank.get(xset) < rank.get(yset)) {
            parent.put(xset, yset);
        } else if (rank.get(xset) > rank.get(yset)) {
            parent.put(yset, xset);
        } else {
            parent.put(yset, xset);
            rank.put(xset, rank.get(xset) + 1);
        }
    }
}

class Solution {
    public boolean areSentencesSimilarTwo(String[] sentence1, String[] sentence2,
            List<List<String>> similarPairs) {
        if (sentence1.length != sentence2.length) {
            return false;
        }

        UnionFind dsu = new UnionFind();
        for (List<String> pair : similarPairs) {
            // Create the graph using the hashed values of the similarPairs.
            dsu.addWord(pair.get(0));
            dsu.addWord(pair.get(1));
            dsu.union(pair.get(0), pair.get(1));
        }

        for (int i = 0; i < sentence1.length; i++) {
            if (sentence1[i].equals(sentence2[i])) {
                continue;
            }
            if (dsu.isWordPresent(sentence1[i]) && dsu.isWordPresent(sentence2[i]) &&
                    dsu.find(sentence1[i]) == dsu.find(sentence2[i])) {
                continue;
            }
            return false;
        }
        return true;
    }
}