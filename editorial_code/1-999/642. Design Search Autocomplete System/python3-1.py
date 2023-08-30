def add_to_trie(self, sentence, count):
    node = self.root
    for c in sentence:
        if c not in node.children:
            node.children[c] = TrieNode()
        node = node.children[c]
        node.sentences[sentence] += count