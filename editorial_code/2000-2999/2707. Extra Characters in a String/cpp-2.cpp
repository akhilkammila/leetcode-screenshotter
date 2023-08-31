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
        unordered_map<int, int> memo;

        function<int(int)> dp = [&](int start) {
            if (start == n) {
                return 0;
            }
            if (memo.count(start)) {
                return memo[start];
            }
            // To count this character as a left over character 
            // move to index 'start + 1'
            int ans = dp(start + 1) + 1;
            TrieNode* node = root;
            for (int end = start; end < n; end++) {
                char c = s[end];
                if (node->children.find(c) == node->children.end()) {
                    break;
                }
                node = node->children[c];
                if (node->is_word) {
                    ans = min(ans, dp(end + 1));
                }
            }

            return memo[start] = ans;
        };

        return dp(0);
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