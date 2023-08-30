class Solution {
    public boolean nimGame(int[] piles) {
        // The count of stones remaining, we recurse until
        // the count becomes zero.
        int remaining = Arrays.stream(piles).sum();

        // Hash map for memoization.
        Map<String, Boolean> memo = new HashMap<>();

        // Is the person to play next the winner?
        // The first person to play is Alice at the beginning.
        // So, if Alice wins, it is going to be true, otherwise
        // it is going to be false.
        return isNextPersonWinner(piles, remaining, memo);
    }
    
    private boolean isNextPersonWinner(int[] piles, int remaining, Map<String, Boolean> memo) {
        // Make a key by concatenating the count of stones
        // in each pile, so key for the state [1, 2, 3] => '1-2-3'.
        String key = getKey(piles);

        // Have we come across this state already?
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        // The current player has no more moves left, so they
        // lose the game.
        if (remaining == 0) {
            return false;
        }

        // Generate all possible next moves and check if
        // the opponent loses the game in any of them.
        for (int i = 0; i < piles.length; i++) {
            // piles[i] is greater than 0.
            for (int j = 1; j <= piles[i]; j++) {
                piles[i] -= j;

                // Next state is created by making a copy of the
                // current state array, and sorting it in ascending
                // order of pile heights.
                int[] nextState = piles.clone();
                Arrays.sort(nextState);

                // If the opponent loses, that means we win.
                if (!isNextPersonWinner(nextState, remaining - j, memo)) {
                    memo.put(key, true);
                    return true;
                }
                piles[i] += j;
            }
        }

        // If none returned false for the opponent, we must have
        // lost the game.
        memo.put(key, false);
        return false;
    }
    
    private String getKey(int[] piles) {
        StringBuilder key = new StringBuilder();
        for (int height: piles) {
            key.append(height).append("-");
        }
        return key.toString();
    }
}