class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return 0;
        }

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.computeIfAbsent(arr[i], v -> new LinkedList<>()).add(i);
        }

        List<Integer> curs = new LinkedList<>(); // store current layer
        curs.add(0);
        Set<Integer> visited = new HashSet<>();
        int step = 0;

        // when current layer exists
        while (!curs.isEmpty()) {
            List<Integer> nex = new LinkedList<>();

            // iterate the layer
            for (int node : curs) {
                // check if reached end
                if (node == n - 1) {
                    return step;
                }

                // check same value
                for (int child : graph.get(arr[node])) {
                    if (!visited.contains(child)) {
                        visited.add(child);
                        nex.add(child);
                    }
                }

                // clear the list to prevent redundant search
                graph.get(arr[node]).clear();

                // check neighbors
                if (node + 1 < n && !visited.contains(node + 1)) {
                    visited.add(node + 1);
                    nex.add(node + 1);
                }
                if (node - 1 >= 0 && !visited.contains(node - 1)) {
                    visited.add(node - 1);
                    nex.add(node - 1);
                }
            }

            curs = nex;
            step++;
        }

        return -1;
    }
}