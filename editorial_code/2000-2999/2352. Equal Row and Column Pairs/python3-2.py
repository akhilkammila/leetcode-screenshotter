class TrieNode:
    def __init__(self):
        self.count = 0
        self.children = {}

class Trie:
    def __init__(self):
        self.trie = TrieNode()

    def insert(self, array):
        my_trie = self.trie
        for a in array:
            if a not in my_trie.children:
                my_trie.children[a] = TrieNode()
            my_trie = my_trie.children[a] 
        my_trie.count += 1

    def search(self, array):
        my_trie = self.trie
        for a in array:
            if a in my_trie.children:
                my_trie = my_trie.children[a]
            else:
                return 0
        return my_trie.count

class Solution:
    def equalPairs(self, grid: List[List[int]]) -> int:
        my_trie = Trie()
        count = 0
        n = len(grid)
        
        for row in grid:
            my_trie.insert(row)
        
        for c in range(n):
            col_array = [grid[i][c] for i in range(n)]
            count += my_trie.search(col_array)
    
        return count    