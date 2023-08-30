class Solution {
    const int m = 1'000'000'007;
    int mul(int a, int b) { return (long long)a * b % m; }

public:
    int numberOfWays(int numPeople) {
        int n = numPeople / 2;
        vector<int> inv(n + 2);
        inv[1] = 1;
        for (int i = 2; i < n + 2; i++) {
            int k = m / i, r = m % i;
            inv[i] = m - mul(k, inv[r]);
        }
        int C = 1;
        for (int i = 0; i < n; i++) {
            C = mul(mul(2 * (2 * i + 1), inv[i + 2]), C);
        }
        return C;
    }
};