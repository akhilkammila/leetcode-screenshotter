class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            adj.computeIfAbsent(a, value -> new ArrayList<Integer>()).add(b);
            adj.computeIfAbsent(b, value -> new ArrayList<Integer>()).add(a);
        }
        int[] dist1 = new int[n + 1], dist2 = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dist1[i] = dist2[i] = -1;
        }
        Queue<int[]> queue = new LinkedList<>();
        // Start with node 1, with its minimum distance.
        queue.offer(new int[] { 1, 1 });
        dist1[1] = 0;

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int node = temp[0];
            int freq = temp[1];

            int timeTaken = freq == 1 ? dist1[node] : dist2[node];
            // If the time_taken falls under the red bracket, wait till the path turns
            // green.
            if ((timeTaken / change) % 2 == 1) {
                timeTaken = change * (timeTaken / change + 1) + time;
            } else {
                timeTaken = timeTaken + time;
            }

            if (!adj.containsKey(node))
                continue;
            for (int neighbor : adj.get(node)) {
                if (dist1[neighbor] == -1) {
                    dist1[neighbor] = timeTaken;
                    queue.offer(new int[] { neighbor, 1 });
                } else if (dist2[neighbor] == -1 && dist1[neighbor] != timeTaken) {
                    if (neighbor == n)
                        return timeTaken;
                    dist2[neighbor] = timeTaken;
                    queue.offer(new int[] { neighbor, 2 });
                }
            }

        }
        return 0;
    }
}