class TrieNode:
    def __init__(self):
        self.children = {}
        self.sentences = defaultdict(int)