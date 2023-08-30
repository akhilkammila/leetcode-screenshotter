class Solution:
    def minWindow(self, s1: str, s2: str) -> str:
        n = len(s1)
        m = len(s2)
        f = [1000000000] * (m + 1)
        g = [None] * (m + 1)
        f[0] = 0
        end = 0
        length = n + 1
        for i in range(1, n + 1):
            g[0] = 0
            for j in range(1, m + 1):
                g[j] = 1 + (f[j - 1] if s1[i - 1] == s2[j - 1] else f[j])
            f = g.copy()
            if f[m] < length:
                end = i
                length = f[m]
        return "" if length > n else s1[end - length:end]