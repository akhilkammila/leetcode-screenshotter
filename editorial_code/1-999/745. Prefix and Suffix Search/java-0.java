class WordFilter {
    TrieNode trie1, trie2;
    public WordFilter(String[] words) {
        trie1 = new TrieNode();
        trie2 = new TrieNode();
        int wt = 0;
        for (String word: words) {
            char[] ca = word.toCharArray();

            TrieNode cur = trie1;
            cur.weight.add(wt);
            for (char letter: ca) {
                if (cur.children[letter - 'a'] == null)
                    cur.children[letter - 'a'] = new TrieNode();
                cur = cur.children[letter - 'a'];
                cur.weight.add(wt);
            }

            cur = trie2;
            cur.weight.add(wt);
            for (int j = ca.length - 1; j >= 0; --j) {
                char letter = ca[j];
                if (cur.children[letter - 'a'] == null)
                    cur.children[letter - 'a'] = new TrieNode();
                cur = cur.children[letter - 'a'];
                cur.weight.add(wt);
            }
            wt++;
        }
    }

    public int f(String prefix, String suffix) {
        TrieNode cur1 = trie1, cur2 = trie2;
        for (char letter: prefix.toCharArray()) {
            if (cur1.children[letter - 'a'] == null) return -1;
            cur1 = cur1.children[letter - 'a'];
        }
        char[] ca = suffix.toCharArray();
        for (int j = ca.length - 1; j >= 0; --j) {
            char letter = ca[j];
            if (cur2.children[letter - 'a'] == null) return -1;
            cur2 = cur2.children[letter - 'a'];
        }

        int ans = -1;
        for (int w1: cur1.weight)
            if (w1 > ans && cur2.weight.contains(w1))
                ans = w1;

        return ans;
    }
}

class TrieNode {
    TrieNode[] children;
    Set<Integer> weight;
    public TrieNode() {
        children = new TrieNode[26];
        weight = new HashSet();
    }
}