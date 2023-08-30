class Solution {
  public int findPaths(int m, int n, int N, int i, int j) {
    if (i == m || j == n || i < 0 || j < 0) return 1;
    if (N == 0) return 0;
    return findPaths(m, n, N - 1, i - 1, j)
        + findPaths(m, n, N - 1, i + 1, j)
        + findPaths(m, n, N - 1, i, j - 1)
        + findPaths(m, n, N - 1, i, j + 1);
  }
}