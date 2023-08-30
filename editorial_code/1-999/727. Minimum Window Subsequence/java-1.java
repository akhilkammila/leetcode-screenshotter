class Solution {
    public String minWindow(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int f[] = new int[m + 1], g[] = new int[m + 1];
        Arrays.fill(f, 1000000000);
        int end = 0, length = n + 1;
        f[0] = 0;
        for (int i = 1; i <= n; i++) {
            g[0] = 0;
            for (int j = 1; j <= m; j++) {
                g[j] = 1 + (s1.charAt(i - 1) == s2.charAt(j - 1) ? f[j - 1] : f[j]);
            }
            f = g.clone();
            if (f[m] < length) {
                length = f[m];
                end = i;
            }
        }
        return length > n ? "" : s1.substring(end - length, end);
    }
}