class Solution {
    public static int minJumps(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return 0;
        }

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.computeIfAbsent(arr[i], v -> new LinkedList<>()).add(i);
        }

        HashSet<Integer> curs = new HashSet<>(); // store layers from start
        curs.add(0);
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        visited.add(n - 1);
        int step = 0;

        HashSet<Integer> other = new HashSet<>(); // store layers from end
        other.add(n - 1);

        // when current layer exists
        while (!curs.isEmpty()) {
            // search from the side with fewer nodes
            if (curs.size() > other.size()) {
                HashSet<Integer> tmp = curs;
                curs = other;
                other = tmp;
            }

            HashSet<Integer> nex = new HashSet<>();

            // iterate the layer
            for (int node : curs) {

                // check same value
                for (int child : graph.get(arr[node])) {
                    if (other.contains(child)) {
                        return step + 1;
                    }
                    if (!visited.contains(child)) {
                        visited.add(child);
                        nex.add(child);
                    }
                }

                // clear the list to prevent redundant search
                graph.get(arr[node]).clear();

                // check neighbors
                if (other.contains(node + 1) || other.contains(node - 1)) {
                    return step + 1;
                }

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