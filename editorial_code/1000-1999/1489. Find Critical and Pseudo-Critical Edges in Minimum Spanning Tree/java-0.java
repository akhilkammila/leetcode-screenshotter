class Solution {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        // Add index to edges for tracking
        int m = edges.length;
        int[][] newEdges = new int[m][4];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 3; j++) {
                newEdges[i][j] = edges[i][j];
            }
            newEdges[i][3] = i;
        }

        // Sort edges based on weight
        Arrays.sort(newEdges, Comparator.comparingInt(edge -> edge[2]));

        // Find MST weight using union-find
        UnionFind ufStd = new UnionFind(n);
        int stdWeight = 0;
        for (int[] edge : newEdges) {
            if (ufStd.union(edge[0], edge[1])) {
                stdWeight += edge[2];
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            result.add(new ArrayList<>());
        }

        // Check each edge for critical and pseudo-critical
        for (int i = 0; i < m; i++) {
            // Ignore this edge and calculate MST weight
            UnionFind ufIgnore = new UnionFind(n);
            int ignoreWeight = 0;
            for (int j = 0; j < m; j++) {
                if (i != j && ufIgnore.union(newEdges[j][0], newEdges[j][1])) {
                    ignoreWeight += newEdges[j][2];
                }
            }
            // If the graph is disconnected or the total weight is greater, 
            // the edge is critical
            if (ufIgnore.maxSize < n || ignoreWeight > stdWeight) {
                result.get(0).add(newEdges[i][3]);
            } else {
                // Force this edge and calculate MST weight
                UnionFind ufForce = new UnionFind(n);
                ufForce.union(newEdges[i][0], newEdges[i][1]);
                int forceWeight = newEdges[i][2];
                for (int j = 0; j < m; j++) {
                    if (i != j && ufForce.union(newEdges[j][0], newEdges[j][1])) {
                        forceWeight += newEdges[j][2];
                    }
                }
                // If total weight is the same, the edge is pseudo-critical
                if (forceWeight == stdWeight) {
                    result.get(1).add(newEdges[i][3]);
                }
            }
        }

        return result;
    }

    class UnionFind {
        int[] parent;
        int[] size;
        int maxSize;

        public UnionFind(int n) {
            parent = new int[n];
            size = new int[n];
            maxSize = 1;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int x) {
            // Finds the root of x
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public boolean union(int x, int y) {
            // Connects x and y
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (size[rootX] < size[rootY]) {
                    int temp = rootX;
                    rootX = rootY;
                    rootY = temp;
                }
                parent[rootY] = rootX;
                size[rootX] += size[rootY];
                maxSize = Math.max(maxSize, size[rootX]);
                return true;
            }
            return false;
        }
    }
}