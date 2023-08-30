Trie = lambda: collections.defaultdict(Trie)
WEIGHT = False

class WordFilter:
    def __init__(self, words: List[str]):
        self.trie = Trie()

        for weight, word in enumerate(words):
            cur = self.trie
            cur[WEIGHT] = weight
            for i, x in enumerate(word):
                #Put all prefixes and suffixes
                tmp = cur
                for letter in word[i:]:
                    tmp = tmp[letter, None]
                    tmp[WEIGHT] = weight

                tmp = cur
                for letter in word[:-i or None][::-1]:
                    tmp = tmp[None, letter]
                    tmp[WEIGHT] = weight

                #Advance letters
                cur = cur[x, word[~i]]
                cur[WEIGHT] = weight

    def f(self, pref: str, suff: str) -> int:
        cur = self.trie
        for a, b in zip_longest(pref, suff[::-1]):
            if (a, b) not in cur: return -1
            cur = cur[a, b]
        return cur[WEIGHT]