class Solution {
    
    private int better(int x, int y) {
        return x < 0 || (y >= 0 && y < x)? y : x;
    }
    
    private int dfs(int[][] mat, List<Integer> operations) {
        if (operations.size() == mat[0].length) {
            int[] changed = new int[mat[0].length];
            int[] lastState = operations
                .stream()
                .mapToInt(Integer::intValue)
                .toArray();
            int maybe = 0;
            for (int[] row : mat) {
                int[] state = changed;
                for (int j = 0; j < row.length; ++j) {
                    state[j] ^= row[j];
                    if (lastState[j] == 1) {
                        state[j] ^= 1;
                        if (j > 0) {
                            state[j - 1] ^= 1;
                        }
                        if (j + 1 < row.length) {
                            state[j + 1] ^= 1;
                        }
                        ++maybe;
                    }
                }
                changed = lastState;
                lastState = state;
            }
            for (int x : lastState) {
                if (x == 1) {
                    return -1;
                }
            }
            return maybe;
        }
        operations.add(0);
        final int maybe1 = dfs(mat, operations);
        operations.set(operations.size() - 1, 1);
        final int maybe2 = dfs(mat, operations);
        operations.remove(operations.size() - 1);
        return better(maybe1, maybe2);
    }
    
    public int minFlips(int[][] mat) {
        return dfs(mat, new ArrayList<>());  
    }
}