def input(self, c: str) -> List[str]:
    if c == "#":
        curr_sentence = "".join(self.curr_sentence)
        self.add_to_trie(curr_sentence, 1)
        self.curr_sentence = []
        self.curr_node = self.root
        return []
    
    self.curr_sentence.append(c)
    if c not in self.curr_node.children:
        self.curr_node = self.dead
        return []
    
    self.curr_node = self.curr_node.children[c]
    sentences = self.curr_node.sentences
    sorted_sentences = sorted(sentences.items(), key = lambda x: (-x[1], x[0]))
    
    ans = []
    for i in range(min(3, len(sorted_sentences))):
        ans.append(sorted_sentences[i][0])
    
    return ans