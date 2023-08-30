private void addToTrie(String sentence, int count) {
    TrieNode node = root;
    for (char c: sentence.toCharArray()) {
        if (!node.children.containsKey(c)) {
            node.children.put(c, new TrieNode());
        }
        
        node = node.children.get(c);
        node.sentences.put(sentence, node.sentences.getOrDefault(sentence, 0) + count);
    }
}