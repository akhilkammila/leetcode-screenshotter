class UnionFind {
    int[] parent;
    int[] rank;

    public UnionFind(int size) {
        parent = new int[size];
        for (int i = 0; i < size; i++)
            parent[i] = i;
        rank = new int[size];
    }

    public int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    public void union_set(int x, int y) {
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
}

class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n-1) {
            return -1;
        }

       UnionFind dsu = new UnionFind(n);
        int numberOfConnectedComponents = n;
        for (int[] connection : connections) {
            if (dsu.find(connection[0]) != dsu.find(connection[1])) {
                numberOfConnectedComponents--;
                dsu.union_set(connection[0], connection[1]);
            }
        }

        return numberOfConnectedComponents - 1;
    }
}