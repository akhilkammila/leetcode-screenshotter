class TrieNode {
public:
    unordered_map<char, TrieNode*> children;
    bool is_word;
};

class Solution {
public:
    int minExtraChar(string s, vector<string>& dictionary) {
        int n = s.length();
        auto root = buildTrie(dictionary);
        vector<int> dp(n + 1, 0);

        for (int start = n - 1; start >= 0; start--) {
            dp[start] = dp[start + 1] + 1;
            auto node = root;
            for (int end = start; end < n; end++) {
                if (node->children.find(s[end]) == node->children.end()) {
                    break;
                }
                node = node->children[s[end]];
                if (node->is_word) {
                    dp[start] = min(dp[start], dp[end + 1]);
                }
            }
        }

        return dp[0];
    }

    TrieNode* buildTrie(vector<string>& dictionary) {
        auto root = new TrieNode();
        for (auto& word : dictionary) {
            auto node = root;
            for (auto& c : word) {
                if (node->children.find(c) == node->children.end()) {
                    node->children[c] = new TrieNode();
                }
                node = node->children[c];
            }
            node->is_word = true;
        }
        return root;
    }
};