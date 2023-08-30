class Solution {
    public boolean reorderedPowerOf2(int N) {
        // Build eg. N = 128 -> A = [1, 2, 8]
        String S = Integer.toString(N);
        int[] A = new int[S.length()];
        for (int i = 0; i < S.length(); ++i)
            A[i] = S.charAt(i) - '0';
        return permutations(A, 0);
    }

    // Return true if A represents a valid power of 2
    public boolean isPowerOfTwo(int[] A) {
        if (A[0] == 0) return false;  // no leading zero

        // Build eg. A = [1, 2, 8] -> N = 128
        int N = 0;
        for (int x: A)
            N = 10 * N + x;

        // Remove the largest power of 2
        while (N > 0 && ((N & 1) == 0))
            N >>= 1;

        // Check that there are no other factors besides 2
        return N == 1;
    }

    /**
     * Returns true if some permutation of (A[start], A[start+1], ...)
     * can result in A representing a power of 2.
     */
    public boolean permutations(int[] A, int start) {
        if (start == A.length)
            return isPowerOfTwo(A);

        // Choose some index i from [start, A.length - 1]
        // to be placed into position A[start].
        for (int i = start; i < A.length; ++i) {
            // Place A[start] with value A[i].
            swap(A, start, i);

            // For each such placement of A[start], if a permutation
            // of (A[start+1], A[start+2], ...) can result in A
            // representing a power of 2, return true.
            if (permutations(A, start + 1))
                return true;

            // Restore the array to the state it was in before
            // A[start] was placed with value A[i].
            swap(A, start, i);
        }

        return false;
    }

    public void swap(int[] A, int i, int j) {
        int t = A[i];
        A[i] = A[j];
        A[j] = t;
    }
}