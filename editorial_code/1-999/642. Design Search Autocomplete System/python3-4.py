import heapq

class TrieNode:
    def __init__(self):
        self.children = {}
        self.sentences = defaultdict(int)

class AutocompleteSystem:
    def __init__(self, sentences: List[str], times: List[int]):
        self.root = TrieNode()
        for sentence, count in zip(sentences, times):
            self.add_to_trie(sentence, count)
            
        self.curr_sentence = []
        self.curr_node = self.root
        self.dead = TrieNode()
        
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
        items = [(val, key) for key, val in self.curr_node.sentences.items()]
        ans = heapq.nsmallest(3, items)
        return [item[1] for item in ans]

    def add_to_trie(self, sentence, count):
        node = self.root
        for c in sentence:
            if c not in node.children:
                node.children[c] = TrieNode()
            node = node.children[c]
            node.sentences[sentence] -= count