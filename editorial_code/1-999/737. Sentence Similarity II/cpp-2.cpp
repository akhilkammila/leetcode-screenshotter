class UnionFind {
private:
    map<string, string> parent;
    map<string, int> rank;

public:
    void addWord(string x) {
        if (!parent.count(x)) {
            parent[x] = x;
            rank[x] = 0;
        }
    }

    bool isWordPresent(string x) {
        if (parent.count(x)) {
            return true;
        }
        return false;
    }

    string find(string x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    void unionSet(string x, string y) {
        string xset = find(x), yset = find(y);
        if (xset == yset) {
            return;
        } else if (rank[xset] < rank[yset]) {
            parent[xset] = yset;
        } else if (rank[xset] > rank[yset]) {
            parent[yset] = xset;
        } else {
            parent[yset] = xset;
            rank[xset]++;
        }
    }
};

class Solution {
public:
    bool areSentencesSimilarTwo(vector<string>& sentence1, vector<string>& sentence2,
                                vector<vector<string>>& similarPairs) {
        if (sentence1.size() != sentence2.size()) {
            return false;
        }

        UnionFind dsu;
        for (auto& pair : similarPairs) {
            // Create the graph using the hashed values of the similarPairs.
            dsu.addWord(pair[0]);
            dsu.addWord(pair[1]);
            dsu.unionSet(pair[0], pair[1]);
        }

        for (int i = 0; i < sentence1.size(); i++) {
            if (sentence1[i] == sentence2[i]) {
                continue;
            }
            if (dsu.isWordPresent(sentence1[i]) && dsu.isWordPresent(sentence2[i]) &&
                dsu.find(sentence1[i]) == dsu.find(sentence2[i])) {
                continue;
            }
            return false;
        }
        return true;
    }
};