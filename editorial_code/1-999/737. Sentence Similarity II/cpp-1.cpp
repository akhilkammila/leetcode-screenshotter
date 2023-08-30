class Solution {
public:
    // Returns true if there is a path from node to dest.
    bool bfs(string& source, unordered_map<string, unordered_set<string>>& adj, string& dest) {
        unordered_set<string> visit;
        queue<string> q;
        q.push(source);
        visit.insert(source);

        while (!q.empty()) {
            string node = q.front();
            q.pop();
            for (auto& neighbor : adj[node]) {
                if (neighbor == dest) {
                    return true;
                }
                if (!visit.count(neighbor)) {
                    visit.insert(neighbor);
                    q.push(neighbor);
                }
            }
        }
        return false;
    }

    bool areSentencesSimilarTwo(vector<string>& sentence1, vector<string>& sentence2,
                                vector<vector<string>>& similarPairs) {
        if (sentence1.size() != sentence2.size()) {
            return false;
        }
        // Create the graph using each pair in similarPairs.
        unordered_map<string, unordered_set<string>> adj;
        for (auto& pair : similarPairs) {
            adj[pair[0]].insert(pair[1]);
            adj[pair[1]].insert(pair[0]);
        }

        for (int i = 0; i < sentence1.size(); i++) {
            if (sentence1[i] == sentence2[i]) {
                continue;
            }
            if (adj.count(sentence1[i]) && adj.count(sentence2[i]) &&
                bfs(sentence1[i], adj, sentence2[i])) {
                continue;
            }
            return false;
        }
        return true;
    }
};