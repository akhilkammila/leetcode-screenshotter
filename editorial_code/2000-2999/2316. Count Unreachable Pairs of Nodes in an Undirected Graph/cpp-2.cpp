class UnionFind {
private:
    vector<int> parent, rank;

public:
    UnionFind(int size) {
        parent.resize(size);
        rank.resize(size, 0);
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }
    int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }
    void union_set(int x, int y) {
        int xset = find(x), yset = find(y);
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
    long long countPairs(int n, vector<vector<int>>& edges) {
        UnionFind dsu(n);
        for (auto edge : edges) {
            dsu.union_set(edge[0], edge[1]);
        }
        unordered_map<int, int> componentSize;
        for (int i = 0; i < n; i++) {
            componentSize[dsu.find(i)]++;
        }

        long long numberOfPaths = 0;
        long long remainingNodes = n;
        for (auto component : componentSize) {
            int componentSize = component.second;
            numberOfPaths += componentSize * (remainingNodes - componentSize);
            remainingNodes -= componentSize;
        }
        return numberOfPaths;
    }
};