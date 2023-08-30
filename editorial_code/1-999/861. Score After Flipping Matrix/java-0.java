class Solution {
    public int matrixScore(int[][] A) {
        int R = A.length, C = A[0].length;
        int[] colsums = new int[C];
        for (int r = 0; r < R; ++r)
            for (int c = 0; c < C; ++c)
                colsums[c] += A[r][c];

        int ans = 0;
        for (int state = 0; state < (1<<R); ++state) {
            // Toggle the rows so that after, 'state' represents
            // the toggled rows.
            if (state > 0) {
                int trans = state ^ (state-1);
                for (int r = 0; r < R; ++r) {
                    if (((trans >> r) & 1) > 0) {
                        for (int c = 0; c < C; ++c) {
                            colsums[c] += A[r][c] == 1 ? -1 : 1;
                            A[r][c] ^= 1;
                        }
                    }
                }
            }

            // Calculate the score with the rows toggled by 'state'
            int score = 0;
            for (int c = 0; c < C; ++c)
                score += Math.max(colsums[c], R - colsums[c]) * (1 << (C-1-c));
            ans = Math.max(ans, score);
        }

        return ans;
    }
}