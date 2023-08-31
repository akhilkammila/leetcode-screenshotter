
def nim_game(piles)
    # The count of stones remaining, we recurse until
    # the count becomes zero.
    remaining = piles.reduce(:+)

    # Hash map for memoization.
    memo = {}

    # Is the person to play next the winner?
    # The first person to play is Alice at the beginning.
    # So, if Alice wins, it is going to be true, otherwise
    # it is going to be false.
    return is_next_person_winner(piles, remaining, memo)
end

def is_next_person_winner(piles, remaining, memo)
    # Make a key by concatenating the count of stones
    # in each pile, so key for the state [1, 2, 3] => '1-2-3'.
    key = piles.join("-")

    # Have we come across this state already?
    return memo[key] if memo.has_key?(key)

    # The current player has no more moves left, so they
    # lose the game.
    return false if remaining == 0

    # Generate all possible next moves, and check if
    # the opponent loses the game in any of them.
    for i in 0...piles.length
        # piles[i] is greater than 0.
        for j in 1..piles[i]
            piles[i] -= j

            # Next state is created by making a copy of the
            # current state array, and sorting it in ascending
            # order of pile heights.
            next_state = piles.clone.sort

            # If the opponent loses, that means we win.
            unless is_next_person_winner(next_state, remaining - j, memo)
                memo[key] = true
                return true
            end
            piles[i] += j
        end
    end
    # If none returned false for the opponent, we must have
    # lost the game.
    memo[key] = false
    return false
end