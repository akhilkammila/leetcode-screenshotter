// Custom class Trie with function to get 3 words starting with given prefix
class Trie
{
    // Node definition of a trie
    struct Node {
        bool isWord = false;
        vector<Node *> children{vector<Node *>(26, NULL)};
    } * Root, *curr;

    // Runs a DFS on trie starting with given prefix and adds all the words in the result, limiting result size to 3
    void dfsWithPrefix(Node * curr, string & word, vector<string> & result) {
        if (result.size() == 3)
            return;
        if (curr->isWord)
            result.push_back(word);

        // Run DFS on all possible paths.
        for (char c = 'a'; c <= 'z'; c++)
            if (curr->children[c - 'a']) {
                word += c;
                dfsWithPrefix(curr->children[c - 'a'], word, result);
                word.pop_back();
            }
    }

public:
    Trie() {
        Root = new Node();
    }
    // Inserts the string in trie.
    void insert(string & s) {
        // Points curr to the root of trie.
        curr = Root;
        for (char &c : s) {
            if (!curr->children[c - 'a'])
                curr->children[c - 'a'] = new Node();
            curr = curr->children[c - 'a'];
        }
        // Mark this node as a completed word.
        curr->isWord = true;
    }
    vector<string> getWordsStartingWith(string & prefix) {
        curr = Root;
        vector<string> result;

        // Move curr to the end of prefix in its trie representation.
        for (char &c : prefix) {
            if (!curr->children[c - 'a'])
                return result;
            curr = curr->children[c - 'a'];
        }
        dfsWithPrefix(curr, prefix, result);
        return result;
    }
};
class Solution {
public:
    vector<vector<string>> suggestedProducts(vector<string> &products,
                                             string searchWord) {
        Trie trie=Trie();
        vector<vector<string>> result;

        // Add all words to trie.
        for(string &w:products)
            trie.insert(w);
        string prefix;
        for (char &c : searchWord) {
            prefix += c;
            result.push_back(trie.getWordsStartingWith(prefix));
        }
        return result;
    }
};