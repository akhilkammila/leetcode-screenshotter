cclass Solution {
public:
    // Returns true if there is a path from source to dest.
    bool dfs(string& source, unordered_set<string>& visit,
             unordered_map<string, unordered_set<string>>& adj, string& dest) {
        visit.insert(source);
        if (source == dest) {
            return true;
        }
        for (auto neighbor : adj[source]) {
            if (!visit.count(neighbor) && dfs(neighbor, visit, adj, dest)) {
                return true;
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
        // The number of nodes in the graph.
        int nodesCount = adj.size();
        for (int i = 0; i < sentence1.size(); i++) {
            if (sentence1[i] == sentence2[i]) {
                continue;
            }
            unordered_set<string> visit;
            if (adj.count(sentence1[i]) && adj.count(sentence2[i]) &&
                dfs(sentence1[i], visit, adj, sentence2[i])) {
                continue;
            }
            return false;
        }
        return true;
    }
};