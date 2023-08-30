class Solution:
    def numberOfWays(self, numPeople: int) -> int:
        m = 1000000007
        n = numPeople // 2
        inv = [None] * (n+2)
        inv[1] = 1
        for i in range(2, n+2):
            k = m // i
            r = m % i
            inv[i] = m - k * inv[r] % m
        C = 1
        for i in range(n):
            C = 2 * (2 * i + 1) * inv[i + 2] * C % m
        return C