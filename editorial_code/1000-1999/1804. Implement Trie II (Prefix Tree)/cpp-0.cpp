class TrieNode {
public:
    TrieNode* links[26];
    int wordsEndingHere = 0;
    int wordsStartingHere = 0;
};

class Trie {
public:
    TrieNode* root;

    Trie() {
        root = new TrieNode();
    }

    void insert(string word) {
        TrieNode* node = root;
        for (char& w : word) {
            int charIndex = w - 'a';
            if (!node->links[charIndex]) {
                node->links[charIndex] = new TrieNode();
            }
            node = node->links[charIndex];
            node->wordsStartingHere++;
        }
        node->wordsEndingHere++;
    }

    int countWordsEqualTo(string word) {
        TrieNode* node = root;
        for (char& w : word) {
            int charIndex = w - 'a';
            if (!node->links[charIndex]) {
                return 0;
            }
            node = node->links[charIndex];
        }
        return node->wordsEndingHere;
    }

    int countWordsStartingWith(string prefix) {
        TrieNode* node = root;
        for (char& w : prefix) {
            int charIndex = w - 'a';
            if (!node->links[charIndex]) {
                return 0;
            }
            node = node->links[charIndex];
        }
        return node->wordsStartingHere;
    }

    void erase(string word) {
        TrieNode* node = root;
        for (char& w : word) {
            int charIndex = w - 'a';
            node = node->links[charIndex];
            node->wordsStartingHere--;
        }
        node->wordsEndingHere--;
    }
};