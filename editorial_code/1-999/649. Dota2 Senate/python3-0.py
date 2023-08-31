class Solution:
    def predictPartyVictory(self, senate: str) -> str:

        # Converting to List as string is immutable, and we need to remove.
        # List will save only eligible senators
        senate = list(senate)

        # Count of Each Type of Senator to check for Winner
        r_count = senate.count('R')
        d_count = len(senate) - r_count

        # Ban the candidate "to_ban", immediate next to "start_at"
        # If have to loop around, then it means next turn will be of
        # senator at same index. Returns loop around boolean
        def ban(to_ban, start_at):

            loop_around = False
            pointer = start_at

            while True:
                if pointer == 0:
                    loop_around = True
                if senate[pointer] == to_ban:
                    senate.pop(pointer)
                    break
                pointer = (pointer + 1) % len(senate)

            return loop_around

        # Turn of Senator at this index
        turn = 0

        # While No Winner
        while r_count > 0 and d_count > 0:

            # Ban the next opponent, starting at one index ahead
            # Taking MOD to loop around
            if senate[turn] == 'R':
                banned_senator_before = ban('D', (turn + 1) % len(senate))
                d_count -= 1
            else:
                banned_senator_before = ban('R', (turn + 1) % len(senate))
                r_count -= 1

            # If the index of the banned senator is before current index,
            # then we need to decrement turn by 1, as we have removed
            # a senator from the list
            if banned_senator_before:
                turn -= 1

            # Increment turn by 1
            turn = (turn + 1) % len(senate)

        # Return Winner depending on the count
        return 'Radiant' if d_count == 0 else 'Dire'