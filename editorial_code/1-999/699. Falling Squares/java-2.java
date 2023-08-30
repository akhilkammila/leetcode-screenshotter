class Solution {
    int[] heights;

    public int query(int L, int R) {
        int ans = 0;
        for (int i = L; i <= R; i++) {
            ans = Math.max(ans, heights[i]);
        }
        return ans;
    }

    public void update(int L, int R, int h) {
        for (int i = L; i <= R; i++) {
            heights[i] = Math.max(heights[i], h);
        }
    }

    public List<Integer> fallingSquares(int[][] positions) {
        //Coordinate Compression
        //HashMap<Integer, Integer> index = ...;
        //int t = ...;

        heights = new int[t];
        int best = 0;
        List<Integer> ans = new ArrayList();

        for (int[] pos: positions) {
            int L = index.get(pos[0]);
            int R = index.get(pos[0] + pos[1] - 1);
            int h = query(L, R) + pos[1];
            update(L, R, h);
            best = Math.max(best, h);
            ans.add(best);
        }
        return ans;
    }
}