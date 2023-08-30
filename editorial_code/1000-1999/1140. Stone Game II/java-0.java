class Solution {
    private int f(int[] piles, int p, int i, int m) {
        if (i == piles.length) {
            return 0;
        }
        int res = p == 1 ? 1000000 : -1, s = 0;
        for (int x = 1; x <= Math.min(2 * m, piles.length - i); x++) {
            s += piles[i + x - 1];
            if (p == 0) {
                res = Math.max(res, s + f(piles, 1, i + x, Math.max(m, x)));
            }
            else {
                res = Math.min(res, f(piles, 0, i + x, Math.max(m, x)));
            }
        }
        return res;
    }
    public int stoneGameII(int[] piles) {
        return f(piles, 0, 0, 1);
    }
}