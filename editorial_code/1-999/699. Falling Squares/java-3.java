class Solution {
    int[] heights;
    int[] blocks;
    int[] blocks_read;
    int B;

    public int query(int left, int right) {
        int ans = 0;
        while (left % B > 0 && left <= right) {
            ans = Math.max(ans, heights[left]);
            ans = Math.max(ans, blocks[left / B]);
            left++;
        }
        while (right % B != B - 1 && left <= right) {
            ans = Math.max(ans, heights[right]);
            ans = Math.max(ans, blocks[right / B]);
            right--;
        }
        while (left <= right) {
            ans = Math.max(ans, blocks[left / B]);
            ans = Math.max(ans, blocks_read[left / B]);
            left += B;
        }
        return ans;
    }

    public void update(int left, int right, int h) {
        while (left % B > 0 && left <= right) {
            heights[left] = Math.max(heights[left], h);
            blocks_read[left / B] = Math.max(blocks_read[left / B], h);
            left++;
        }
        while (right % B != B - 1 && left <= right) {
            heights[right] = Math.max(heights[right], h);
            blocks_read[right / B] = Math.max(blocks_read[right / B], h);
            right--;
        }
        while (left <= right) {
            blocks[left / B] = Math.max(blocks[left / B], h);
            left += B;
        }
    }

    public List<Integer> fallingSquares(int[][] positions) {
        //Coordinate Compression
        //HashMap<Integer, Integer> index = ...;
        //int t = ...;

        heights = new int[t];
        B = (int) Math.sqrt(t);
        blocks = new int[B+2];
        blocks_read = new int[B+2];

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