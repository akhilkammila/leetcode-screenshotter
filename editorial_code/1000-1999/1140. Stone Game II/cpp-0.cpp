class Solution {
public:
    int stoneGameII(vector<int>& piles) {
        int n = piles.size();
        function<int(int, int, int)> f = [&](int p, int i, int m) -> int {
            if (i == n) {
                return 0;
            }
            int res = p == 1 ? 1000000 : -1, s = 0;
            for (int x = 1; x <= min(2 * m, n - i); x++) {
                s += piles[i + x - 1];
                if (p == 0) {
                    res = max(res, s + f(1, i + x, max(m, x)));
                }
                else {
                    res = min(res, f(0, i + x, max(m, x)));
                }
            }
            return res;
        };
        return f(0, 0, 1);
    }
};