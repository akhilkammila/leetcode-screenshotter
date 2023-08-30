struct TrieNode {
    bool flag;
    map<char, TrieNode*> next;
};
struct Trie {
    TrieNode* root;

    Trie() { root = new TrieNode(); }

    void insert(string word) {
        TrieNode* p = root;
        for (int i = 0; i < word.length(); ++i) {
            if ((p->next).count(word[i]) == 0) {
                (p->next).insert(make_pair(word[i], new TrieNode()));
            }
            p = (p->next)[word[i]];
        }
        p->flag = true;
    }
};

class Solution {
public:
    vector<vector<int>> indexPairs(string text, vector<string>& words) {
        Trie trie;
        for (const string& word : words) {
            trie.insert(word);
        }
        vector<vector<int>> result;
        for (int i = 0; i < text.size(); i++) {
            TrieNode* p = trie.root;
            for (int j = i; j < text.size(); j++) {
                if ((p->next).count(text[j]) == 0) {
                    break;
                }
                p = (p->next)[text[j]];
                if (p->flag) {
                    result.push_back({i, j});
                }
            }
        }
        return result;
    }
};