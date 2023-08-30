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
            if (rank[rootX] > rank[rootY]) {
                swap(rootX, rootY);
            }
            // Modify the root of the smaller group as the root of the
            // larger group, also increment the size of the larger group.
            root[rootX] = rootY;
            rank[rootY] += rank[rootX];
        }
    }
};

class Solution {
public:
    bool validPath(int n, vector<vector<int>>& edges, int source, int destination) {
        UnionFind uf(n);

        for (auto& edge : edges) {
            uf.join(edge[0], edge[1]);
        }
        
        return uf.find(source) == uf.find(destination);
    }
};