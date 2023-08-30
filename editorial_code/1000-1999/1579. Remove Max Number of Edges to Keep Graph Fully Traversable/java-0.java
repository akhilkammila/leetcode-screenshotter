class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        // Different objects for Alice and Bob.
        UnionFind Alice = new UnionFind(n);
        UnionFind Bob = new UnionFind(n);

        int edgesRequired = 0;
        // Perform union for edges of type = 3, for both Alice and Bob.
        for (int[] edge : edges) {
            if (edge[0] == 3) {
                edgesRequired += (Alice.performUnion(edge[1], edge[2]) | Bob.performUnion(edge[1], edge[2]));
            }
        }

        // Perform union for Alice if type = 1 and for Bob if type = 2.
        for (int[] edge : edges) {
            if (edge[0] == 1) {
                edgesRequired += Alice.performUnion(edge[1], edge[2]);
            } else if (edge[0] == 2) {
                edgesRequired += Bob.performUnion(edge[1], edge[2]);
            }
        }

        // Check if the Graphs for Alice and Bob have n - 1 edges or is a single component.
        if (Alice.isConnected() && Bob.isConnected()) {
            return edges.length - edgesRequired;
        }
        
        return -1;
    }

    private class UnionFind {
        int[] representative;
        int[] componentSize;
        // Number of distinct components in the graph.
        int components;

        // Initialize the list representative and componentSize
        // Each node is representative of itself with size 1.
        public UnionFind(int n) {
            components = n;
            representative = new int[n + 1];
            componentSize = new int[n + 1];

            for (int i = 0; i <= n; i++) {
                representative[i] = i;
                componentSize[i] = 1;
            }
        }

        // Get the root of a node.
        int findRepresentative(int x) {
            if (representative[x] == x) {
                return x;
            }

            // Path compression.
            return representative[x] = findRepresentative(representative[x]);
        }
        
        // Perform the union of two components that belongs to node x and node y.
        int performUnion(int x, int y) {       
            x = findRepresentative(x); y = findRepresentative(y);

            if (x == y) {
                return 0;
            }

            if (componentSize[x] > componentSize[y]) {
                componentSize[x] += componentSize[y];
                representative[y] = x;
            } else {
                componentSize[y] += componentSize[x];
                representative[x] = y;
            }

            components--;
            return 1;
        }

        // Returns true if all nodes get merged to one.
        boolean isConnected() {
            return components == 1;
        }
    }
}
