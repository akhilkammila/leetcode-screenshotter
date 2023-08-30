class Solution {
    int m, n;

    Set<Pair<Integer, Integer>> find(int[][] board) {
        Set<Pair<Integer, Integer>> crushedSet = new HashSet<>();

        // Check vertically adjacent candies
        for (int r = 1; r < m - 1; r++) {
            for (int c = 0; c < n; c++) {
                if (board[r][c] == 0) {
                    continue;
                }
                if (board[r][c] == board[r - 1][c] && board[r][c] == board[r + 1][c]) {
                    crushedSet.add(new Pair<>(r, c));
                    crushedSet.add(new Pair<>(r - 1, c));
                    crushedSet.add(new Pair<>(r + 1, c));
                }
            }
        }

        // Check horizontally adjacent candies
        for (int r = 0; r < m; r++) {
            for (int c = 1; c < n - 1; c++) {
                if (board[r][c] == 0) {
                    continue;
                }
                if (board[r][c] == board[r][c - 1] && board[r][c] == board[r][c + 1]) {
                    crushedSet.add(new Pair<>(r, c));
                    crushedSet.add(new Pair<>(r, c - 1));
                    crushedSet.add(new Pair<>(r, c + 1));
                }
            }
        }
        return crushedSet;
    }

    void crush(int[][] board, Set<Pair<Integer, Integer>> crushedSet) {
        for (Pair<Integer, Integer> pair : crushedSet) {
            int r = pair.getKey();
            int c = pair.getValue();
            board[r][c] = 0;
        }
    }

    void drop(int[][] board) {
        for (int c = 0; c < n; c++) {
            int lowestZero = -1;

            // Iterate over each column
            for (int r = m - 1; r >= 0; r--) {
                if (board[r][c] == 0) {
                    lowestZero = Math.max(lowestZero, r);
                } else if (lowestZero >= 0) {
                    int temp = board[r][c];
                    board[r][c] = board[lowestZero][c];
                    board[lowestZero][c] = temp;
                    lowestZero--;
                }
            }
        }
    }

    public int[][] candyCrush(int[][] board) {
        m = board.length;
        n = board[0].length;
        Set<Pair<Integer, Integer>> crushedSet = find(board);
        while (!crushedSet.isEmpty()) {
            crush(board, crushedSet);
            drop(board);
            crushedSet = find(board);
        }

        return board;
    }
}