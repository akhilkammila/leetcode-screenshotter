class UnionFind {
    vector<int> root, rank;
public:
    UnionFind(int n) : root(n), rank(n, 1) {
        iota(root.begin(), root.end(), 0);
    }
    int find(int x) {
        if (x != root[x]) {
            root[x] = find(root[x]);
        }
        return root[x];
    }
    void join(int x, int y) {
        int rootX = find(x), rootY = find(y);
        if (rootX != rootY) {
            if (rank[rootX] > root[rootY]) {
                swap(rootX, rootY);
            }
            root[rootX] = rootY;
            rank[rootY] += rank[rootX];
        }
    }
    int getSize(int x) {
        return rank[find(x)];
    }
};

class Solution {
public:
    int reachableNodes(int n, vector<vector<int>>& edges, vector<int>& restricted) {
        UnionFind uf(n);
        unordered_set<int> restSet(restricted.begin(), restricted.end());

        for (auto edge : edges) {
            int a = edge[0], b = edge[1];
            if (restSet.find(a) == restSet.end() && restSet.find(b) == restSet.end()) {
                uf.join(a, b);
            }
        }
        
        return uf.getSize(0);
    }
};