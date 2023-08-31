class Solution:
    def predictPartyVictory(self, senate: str) -> str:

        # Number of Senators
        N = len(senate)

        # To mark Banned Senators
        banned = [False] * N

        # Count of Each Type of Senator who are not-banned
        r_count = senate.count('R')
        d_count = N - r_count

        # Ban the candidate "to_ban", immediate next to "start_at"
        def ban(to_ban, start_at):

            # Find the next eligible senator of "to_ban" type
            # On found, mark him as banned
            pointer = start_at
            while True:
                if senate[pointer] == to_ban and not banned[pointer]:
                    banned[pointer] = True
                    break
                pointer = (pointer + 1) % len(senate)

        # Turn of Senator at this Index
        turn = 0

        # While both parties have at least one senator
        while r_count > 0 and d_count > 0:

            if not banned[turn]:
                if senate[turn] == 'R':
                    ban('D', (turn + 1) % N)
                    d_count -= 1
                else:
                    ban('R', (turn + 1) % N)
                    r_count -= 1

            turn = (turn + 1) % N

        return 'Radiant' if d_count == 0 else 'Dire'
