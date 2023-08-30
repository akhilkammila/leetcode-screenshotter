class Solution {
    private long mod = (long)1e9 + 7;
    private long[][] table;

    public int numOfWays(int[] nums) {
        int m = nums.length;
        
        // Table of Pascal's triangle
        table = new long[m][m];
        for (int i = 0; i < m; ++i) {
            table[i][0] = table[i][i] = 1;
        }
        for (int i = 2; i < m; i++) {
            for (int j = 1; j < i; j++) {
                table[i][j] = (table[i - 1][j - 1] + table[i - 1][j]) % mod;
            }
        }
        List<Integer> arrList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        return (int)((dfs(arrList) - 1) % mod);
    }

    private long dfs(List<Integer> nums) {
        int m = nums.size();
        if (m < 3) {
            return 1;
        }

        List<Integer> leftNodes = new ArrayList<>();
        List<Integer> rightNodes = new ArrayList<>();
        for (int i = 1; i < m; ++i) {
            if (nums.get(i) < nums.get(0)) {
                leftNodes.add(nums.get(i));
            } else {
                rightNodes.add(nums.get(i));
            }
        }
        long leftWays = dfs(leftNodes) % mod;
        long rightWays = dfs(rightNodes) % mod;

        return (((leftWays * rightWays) % mod) * table[m - 1][leftNodes.size()]) % mod;
    }
}