class TrieNode {
    boolean isWord;
    Map<Character, TrieNode> children;
    TrieNode() {
        this.children = new HashMap<>();
    }
}

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        TrieNode root = new TrieNode();
        for (String word: wordDict) {
            TrieNode curr = root;
            for (char c: word.toCharArray()) {
                if (!curr.children.containsKey(c)) {
                    curr.children.put(c, new TrieNode());
                }

                curr = curr.children.get(c);
            }
            
            curr.isWord = true;
        }
        
        boolean[] dp = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (i == 0 || dp[i - 1]) {
                TrieNode curr = root;
                for (int j = i; j < s.length(); j++) {
                    char c = s.charAt(j);
                    if (!curr.children.containsKey(c)) {
                        // No words exist
                        break;
                    }
                    
                    curr = curr.children.get(c);
                    if (curr.isWord) {
                        dp[j] = true;
                    }
                }
            }
        }
        
        return dp[s.length() - 1];
    }
}