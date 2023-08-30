class TrieNode {
    public boolean flag;
    public Map<Character, TrieNode> next = new HashMap<>();
}

class Trie {
    public TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new TrieNode());
            }
            cur = cur.next.get(c);
        }
        cur.flag = true;
    }
}

class Solution {
    public int[][] indexPairs(String text, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        List<int[]> result = new ArrayList();
        for (int i = 0; i < text.length(); i++) {
            TrieNode p = trie.root;
            for (int j = i; j < text.length(); j++) {
                if (p.next.get(text.charAt(j)) == null) {
                    break;
                }
                p = p.next.get(text.charAt(j));
                if (p.flag) {
                    result.add(new int[] { i, j });
                }
            }
        }
        int[][] ans = new int[result.size()][];
        ans = result.toArray(ans);
        return ans;
    }
}