class Solution {
    public int at mostNGivenDigitSet(String[] D, int N) {
        int B = D.length; // bijective-base B
        char[] ca = String.valueOf(N).toCharArray();
        int K = ca.length;
        int[] A = new int[K];
        int t = 0;

        for (char c: ca) {
            int c_index = 0;  // Largest such that c >= D[c_index - 1]
            boolean match = false;
            for (int i = 0; i < B; ++i) {
                if (c >= D[i].charAt(0))
                    c_index = i+1;
                if (c == D[i].charAt(0))
                    match = true;
            }

            A[t++] = c_index;
            if (match) continue;

            if (c_index == 0) { // subtract 1
                for (int j = t-1; j > 0; --j) {
                    if (A[j] > 0) break;
                    A[j] += B;
                    A[j-1]--;
                }
            }

            while (t < K)
                A[t++] = B;
            break;
        }

        int ans = 0;
        for (int x: A)
            ans = ans * B + x;
        return ans;
    }
}