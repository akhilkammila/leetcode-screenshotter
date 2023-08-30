class Solution {
    public int bfs(int n, Map<Integer, List<List<Integer>>> adj) {
        boolean[] visit = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
        int answer = Integer.MAX_VALUE;

        q.offer(1);
        visit[1] = true;

        while (!q.isEmpty()) {
            int node = q.poll();

            if (!adj.containsKey(node)) {
                continue;
            }
            for (List<Integer> edge : adj.get(node)) {
                answer = Math.min(answer, edge.get(1));
                if (!visit[edge.get(0)]) {
                    visit[edge.get(0)] = true;
                    q.offer(edge.get(0));
                }
            }
        }
        return answer;
    }

    public int minScore(int n, int[][] roads) {
        Map<Integer, List<List<Integer>>> adj = new HashMap<>();
        for (int[] road : roads) {
            adj.computeIfAbsent(road[0], k -> new ArrayList<List<Integer>>()).add(
                    Arrays.asList(road[1], road[2]));
            adj.computeIfAbsent(road[1], k -> new ArrayList<List<Integer>>()).add(
                    Arrays.asList(road[0], road[2]));
        }
        return bfs(n, adj);
    }
}