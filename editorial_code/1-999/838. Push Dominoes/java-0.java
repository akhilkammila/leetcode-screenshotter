class Solution {
    public String pushDominoes(String dominoes) {
        int N = dominoes.length();
        int[] indexes = new int[N+2];
        char[] symbols = new char[N+2];
        int len = 1;
        indexes[0] = -1;
        symbols[0] = 'L';

        for (int i = 0; i < N; ++i)
            if (dominoes.charAt(i) != '.') {
                indexes[len] = i;
                symbols[len++] = dominoes.charAt(i);
            }

        indexes[len] = N;
        symbols[len++] = 'R';

        char[] ans = dominoes.toCharArray();
        for (int index = 0; index < len - 1; ++index) {
            int i = indexes[index], j = indexes[index+1];
            char x = symbols[index], y = symbols[index+1];
            char write;
            if (x == y) {
                for (int k = i+1; k < j; ++k)
                    ans[k] = x;
            } else if (x > y) { // RL
                for (int k = i+1; k < j; ++k)
                    ans[k] = k-i == j-k ? '.' : k-i < j-k ? 'R' : 'L';
            }
        }

        return String.valueOf(ans);
    }
}