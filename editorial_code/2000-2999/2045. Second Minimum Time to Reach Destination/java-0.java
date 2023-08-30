class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            adj.computeIfAbsent(a, value -> new ArrayList<Integer>()).add(b);
            adj.computeIfAbsent(b, value -> new ArrayList<Integer>()).add(a);
        }
        int[] dist1 = new int[n + 1], dist2 = new int[n + 1], freq = new int[n + 1];
        // dist1[i] stores the minimum time taken to reach node i from node 1. dist2[i]
        // stores the second minimum time taken to reach node from node 1. freq[i] stores
        // the number of times a node is popped out of the heap.
        for (int i = 1; i <= n; i++) {
            dist1[i] = dist2[i] = Integer.MAX_VALUE;
            freq[i] = 0;
        }

        PriorityQueue<int []> pq = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        pq.offer(new int[] {1, 0});
        dist1[1] = 0;

        while (!pq.isEmpty()) {
            int [] temp = pq.poll();
            int node = temp[0];
            int time_taken = temp[1];

            freq[node]++;

            // If the node is being visited for the second time and is 'n', return the
            // answer.
            if (freq[node] == 2 && node == n)
                return time_taken;
            // If the current light is red, wait till the path turns green.
            if ((time_taken / change) % 2 == 1)
                time_taken = change * (time_taken / change + 1) + time;
            else
                time_taken = time_taken + time;

            if (!adj.containsKey(node))
                continue;
            for (int neighbor : adj.get(node)) {
                // Ignore nodes that have already popped out twice, we are not interested in
                // visiting them again.
                if (freq[neighbor] == 2)
                    continue;

                // Update dist1 if it's more than the current time_taken and store its value in
                // dist2 since that becomes the second minimum value now.
                if (dist1[neighbor] > time_taken) {
                    dist2[neighbor] = dist1[neighbor];
                    dist1[neighbor] = time_taken;
                    pq.offer(new int [] {neighbor, time_taken});
                } else if (dist2[neighbor] > time_taken && dist1[neighbor] != time_taken) {
                    dist2[neighbor] = time_taken;
                    pq.offer(new int[] {neighbor, time_taken});
                }
            }

        }
        return 0;
    }
}