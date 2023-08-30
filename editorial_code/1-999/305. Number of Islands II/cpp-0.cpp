class UnionFind {
private:
    vector<int> parent, rank;
    int count;

public:
    UnionFind(int size) {
        parent.resize(size, -1);
        rank.resize(size, 0);
        count = 0;
    }

    void addLand(int x) {
        if (parent[x] >= 0) return;
        parent[x] = x;
        count++;
    }

    bool isLand(int x) {
        if (parent[x] >= 0) {
            return true;
        } else {
            return false;
        }
    }

    int numberOfIslands() { return count; }

    int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
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
        count--;
    }
};

class Solution {
public:
    vector<int> numIslands2(int m, int n, vector<vector<int>>& positions) {
        int x[] = {-1, 1, 0, 0};
        int y[] = {0, 0, -1, 1};
        UnionFind dsu(m * n);
        vector<int> answer;

        for (auto& position : positions) {
            int landPosition = position[0] * n + position[1];
            dsu.addLand(landPosition);

            for (int i = 0; i < 4; i++) {
                int neighborX = position[0] + x[i];
                int neighborY = position[1] + y[i];
                int neighborPosition = neighborX * n + neighborY;
                // If neighborX and neighborY correspond to a point in the grid and there is a land
                // at that point, then merge it with the current land.
                if (neighborX >= 0 && neighborX < m && neighborY >= 0 && neighborY < n &&
                    dsu.isLand(neighborPosition)) {
                    dsu.union_set(landPosition, neighborPosition);
                }
            }
            answer.push_back(dsu.numberOfIslands());
        }
        return answer;
    }
};