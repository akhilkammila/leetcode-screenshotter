class TrieNode:
    def __init__(self):
        self.links = [None] * 26
        self.words_ending_here = 0
        self.words_starting_here = 0

class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        node = self.root
        for w in word:
            char_index = ord(w) - ord('a')
            if not node.links[char_index]:
                node.links[char_index] = TrieNode()
            node = node.links[char_index]
            node.words_starting_here += 1
        node.words_ending_here += 1

    def countWordsEqualTo(self, word: str) -> int:
        node = self.root
        for w in word:
            char_index = ord(w) - ord('a')
            if not node.links[char_index]:
                return 0
            node = node.links[char_index]
        return node.words_ending_here

    def countWordsStartingWith(self, prefix: str) -> int:
        node = self.root
        for w in prefix:
            char_index = ord(w) - ord('a')
            if not node.links[char_index]:
                return 0
            node = node.links[char_index]
        return node.words_starting_here

    def erase(self, word: str) -> None:
        node = self.root
        for w in word:
            char_index = ord(w) - ord('a')
            node = node.links[char_index]
            node.words_starting_here -= 1
        node.words_ending_here -= 1