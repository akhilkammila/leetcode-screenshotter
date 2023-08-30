class Solution {

    protected int convolute(int[][] A, int[][] kernel, int xShift, int yShift) {
        int result = 0;
        for (int row = 0; row < A.length; ++row)
            for (int col = 0; col < A.length; ++col)
                result += A[row][col] * kernel[row + yShift][col + xShift];
        return result;
    }

    public int largestOverlap(int[][] A, int[][] B) {

        int N = A.length;
        int[][] B_padded = new int[3 * N - 2][3 * N - 2];
        for (int row = 0; row < N; ++row)
            for (int col = 0; col < N; ++col)
                B_padded[row + N - 1][col + N - 1] = B[row][col];

        int maxOverlaps = 0;
        for (int xShift = 0; xShift < 2 * N - 1; ++xShift)
            for (int yShift = 0; yShift < 2 * N - 1; ++yShift) {
                maxOverlaps = Math.max(maxOverlaps,
                    convolute(A, B_padded, xShift, yShift));
            }

        return maxOverlaps;
    }
}