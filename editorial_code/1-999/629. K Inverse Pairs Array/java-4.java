public class Solution {
    Integer[][] memo = new Integer[1001][1001];
    int M = 1000000007;
    public int kInversePairs(int n, int k) {
        return ((inv(n, k) + M - (k > 0 ? inv(n, k - 1) : 0)) % M);
    }
    public int inv(int n, int k) {
        if (n == 0)
            return 0;
        if (k == 0)
            return 1;
        if (memo[n][k] != null)
            return memo[n][k];
        int val = (inv(n - 1, k) + M - ((k - n) >= 0 ? inv(n - 1, k - n) : 0)) % M;
        memo[n][k] = (inv(n, k - 1) + val) % M;
        return memo[n][k];
    }
}