class Solution {
    public int findKthNumber(int m, int n, int k) {
        int[] table = new int[m*n];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                table[(i - 1) * n + j - 1] = i * j;
            }
        }
        Arrays.sort(table);
        return table[k-1];
    }
}