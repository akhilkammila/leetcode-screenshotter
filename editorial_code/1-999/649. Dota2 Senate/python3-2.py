class Solution:
    def predictPartyVictory(self, senate: str) -> str:

        # Number of Senators
        N = len(senate)

        # To mark Banned Senators
        banned = [False] * N

        # List of indices of Eligible Radiant and Dire Senators
        r_indices = [i for i in range(N) if senate[i] == 'R']
        d_indices = [i for i in range(N) if senate[i] == 'D']

        # Ban the senator of "indices" array next to "start_at"
        def ban(indices_array, start_at):

            # Find the index of "index of senator to ban" using Binary Search
            temp = bisect.bisect_left(indices_array, start_at)

            # If start_at is more than the last index,
            # then start from the beginning. Ban the first senator
            if temp == len(indices_array):
                banned[indices_array.pop(0)] = True

            # Else, Ban the senator at the index
            else:
                banned[indices_array.pop(temp)] = True

        # Turn of Senator at this Index
        turn = 0

        # While both parties have at least one senator
        while r_indices and d_indices:

            if not banned[turn]:
                if senate[turn] == 'R':
                    ban(d_indices, turn)
                else:
                    ban(r_indices, turn)

            turn = (turn + 1) % N

        return 'Radiant' if d_indices == [] else 'Dire'
