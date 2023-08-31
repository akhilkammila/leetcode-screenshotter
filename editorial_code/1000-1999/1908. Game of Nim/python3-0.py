class Solution:
    def nimGame(self, piles: List[int]) -> bool:
        # The count of stones remaining, we recurse until
        # the count becomes zero.
        remaining = sum(piles)

        # Hash map for memoization.
        memo = {}

        # Is the person to play next the winner?
        # The first person to play is Alice at the beginning.
        # So, if Alice wins, it is going to be true, otherwise
        # it is going to be a false.
        return self.__is_next_person_winner(piles, remaining, memo)

    def __is_next_person_winner(self, piles, remaining, memo):
        # Make a key by concatenating the count of stones
        # in each pile, so key for the state [1, 2, 3] => '1-2-3'.
        key = "-".join(map(str, piles))

        # Have we come across this state already?
        if key in memo:
            return memo[key]

        # The current player has no more moves left, so they
        # lose the game.
        if remaining == 0:
            return False

        # Generate all possible next moves, and check if
        # the opponent loses the game in any of them.
        for i in range(len(piles)):
            # piles[i] is greater than 0.
            for j in range(1, piles[i] + 1):
                piles[i] -= j

                # Next state is created by making a copy of the
                # current state array, and sorting it in ascending
                # order of pile heights.
                next_state = sorted(piles)

                # If the opponent loses, that means we win.
                if not self.__is_next_person_winner(next_state, remaining - j, memo):
                    memo[key] = True
                    return True
                piles[i] += j

        # If none returned false for the opponent, we must have
        # lost the game.
        memo[key] = False
        return False
