class UnionFind {
    private int[] root;
    private int[] rank;
    public UnionFind(int n) {
        this.root = new int[n];
        this.rank = new int[n];
        for (int i = 0; i < n; ++i) {
            this.root[i] = i;
            this.rank[i] = 1;
        }
    }
    public int find(int x) {
        if (this.root[x] != x) {
            this.root[x] = find(this.root[x]);
        }
        return this.root[x];
    }
    public void union(int x, int y) {
        int rootX = find(x), rootY = find(y);
        if (rootX != rootY) {
            if (this.rank[rootX] > this.rank[rootY]) {
                int tmp = rootX;
                rootX = rootY;
                rootY = tmp;
            }
            this.root[rootX] = rootY;
            this.rank[rootY] += this.rank[rootX];
        }
    }
    public int getSize(int x) {
        return this.rank[find(x)];
    }
}

class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        UnionFind uf = new UnionFind(n);
        Set<Integer> restSet = new HashSet<>();

        for(int node : restricted){
            restSet.add(node);
        }

        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            if (!restSet.contains(a) && !restSet.contains(b)) {
                uf.union(a, b);
            }
        }
        return uf.getSize(0);
    }
}