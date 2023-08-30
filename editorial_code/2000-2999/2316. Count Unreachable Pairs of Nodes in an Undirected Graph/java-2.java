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
    public long countPairs(int n, int[][] edges) {
        UnionFind dsu = new UnionFind(n);
        for(int[] edge: edges) {
            dsu.union_set(edge[0], edge[1]);
        }

        Map<Integer, Integer> componentSize = new HashMap<>();
        for(int i= 0; i<n; i++) {
            int parent = dsu.find(i);
            if(componentSize.containsKey(parent)) {
                componentSize.put(parent, componentSize.get(parent) + 1);
            } else {
                componentSize.put(parent, 1);
            }
        }
        
        long numberOfPaths = 0;
        long remainingNodes = n;
        for (int componentSize : componentSize.values()) {
            numberOfPaths += componentSize * (remainingNodes - componentSize);
            remainingNodes -= componentSize;
        }
        return numberOfPaths;
    }
}