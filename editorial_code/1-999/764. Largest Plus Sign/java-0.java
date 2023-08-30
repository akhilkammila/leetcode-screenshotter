class Solution {
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        Set<Integer> banned = new HashSet();
        for (int[] mine: mines)
            banned.add(mine[0] * N + mine[1]);
            
        int ans = 0;
        for (int r = 0; r < N; ++r) for (int c = 0; c < N; ++c) {
            int k = 0;
            while (k <= r && r < N-k && k <= c && c < N-k &&
                    !banned.contains((r-k)*N + c) &&
                    !banned.contains((r+k)*N + c) &&
                    !banned.contains(r*N + c-k) &&
                    !banned.contains(r*N + c+k))
                k++;
            
            ans = Math.max(ans, k);
        }
        return ans;
    }
}