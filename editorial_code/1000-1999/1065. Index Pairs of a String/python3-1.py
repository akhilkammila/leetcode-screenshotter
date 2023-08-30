class TrieNode:
    def __init__(self):
        self.flag = False
        self.next = dict()


class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word):
        p = self.root
        for c in word:
            if c not in p.next:
                p.next[c] = TrieNode()
            p = p.next[c]
        p.flag = True


class Solution:
    def indexPairs(self, text: str, words: List[str]) -> List[List[int]]:
        trie = Trie()
        for word in words:
            trie.insert(word)
        result = []
        for i in range(len(text)):
            p = trie.root
            for j in range(i, len(text)):
                if text[j] not in p.next:
                    break
                p = p.next[text[j]]
                if p.flag:
                    result.append([i, j])
        return result