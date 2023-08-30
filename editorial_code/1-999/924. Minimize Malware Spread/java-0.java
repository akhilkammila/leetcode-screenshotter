class Solution {
    public int minMalwareSpread(int[][] graph, int[] initial) {
        // 1. Color each component.
        // colors[node] = the color of this node.

        int N = graph.length;
        int[] colors = new int[N];
        Arrays.fill(colors, -1);
        int C = 0;

        for (int node = 0; node < N; ++node)
            if (colors[node] == -1)
                dfs(graph, colors, node, C++);

        // 2. Size of each color.
        int[] size = new int[C];
        for (int color: colors)
            size[color]++;

        // 3. Find unique colors.
        int[] colorCount = new int[C];
        for (int node: initial)
            colorCount[colors[node]]++;

        // 4. Answer
        int ans = Integer.MAX_VALUE;
        for (int node: initial) {
            int c = colors[node];
            if (colorCount[c] == 1) {
                if (ans == Integer.MAX_VALUE)
                    ans = node;
                else if (size[c] > size[colors[ans]])
                    ans = node;
                else if (size[c] == size[colors[ans]] && node < ans)
                    ans = node;
            }
        }

        if (ans == Integer.MAX_VALUE)
            for (int node: initial)
                ans = Math.min(ans, node);

        return ans;
    }

    public void dfs(int[][] graph, int[] colors, int node, int color) {
        colors[node] = color;
        for (int nei = 0; nei < graph.length; ++nei)
            if (graph[node][nei] == 1 && colors[nei] == -1)
                dfs(graph, colors, nei, color);
    }
}