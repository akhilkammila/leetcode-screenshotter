class WordFilter {
    TrieNode trie;
    public WordFilter(String[] words) {
        trie = new TrieNode();
        int wt = 0;
        for (String word: words) {
            TrieNode cur = trie;
            cur.weight = wt;
            int L = word.length();
            char[] chars = word.toCharArray();
            for (int i = 0; i < L; ++i) {

                TrieNode tmp = cur;
                for (int j = i; j < L; ++j) {
                    int code = (chars[j] - '`') * 27;
                    if (tmp.children.get(code) == null)
                        tmp.children.put(code, new TrieNode());
                    tmp = tmp.children.get(code);
                    tmp.weight = wt;
                }

                tmp = cur;
                for (int k = L - 1 - i; k >= 0; --k) {
                    int code = (chars[k] - '`');
                    if (tmp.children.get(code) == null)
                        tmp.children.put(code, new TrieNode());
                    tmp = tmp.children.get(code);
                    tmp.weight = wt;
                }

                int code = (chars[i] - '`') * 27 + (chars[L - 1 - i] - '`');
                if (cur.children.get(code) == null)
                    cur.children.put(code, new TrieNode());
                cur = cur.children.get(code);
                cur.weight = wt;

            }
            wt++;
        }
    }

    public int f(String prefix, String suffix) {
        TrieNode cur = trie;
        int i = 0, j = suffix.length() - 1;
        while (i < prefix.length() || j >= 0) {
            char c1 = i < prefix.length() ? prefix.charAt(i) : '`';
            char c2 = j >= 0 ? suffix.charAt(j) : '`';
            int code = (c1 - '`') * 27 + (c2 - '`');
            cur = cur.children.get(code);
            if (cur == null) return -1;
            i++; j--;
        }
        return cur.weight;
    }
}

class TrieNode {
    Map<Integer, TrieNode> children;
    int weight;
    public TrieNode() {
        children = new HashMap();
        weight = 0;
    }
}