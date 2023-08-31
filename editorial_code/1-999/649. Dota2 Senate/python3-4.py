class Solution:
    def predictPartyVictory(self, senate: str) -> str:

        # Eligible Senators of each party
        r_count = senate.count('R')
        d_count = len(senate) - r_count

        # Floating Ban Count
        d_floating_ban = 0
        r_floating_ban = 0

        # Queue of Senators
        q = deque(senate)

        # While any party has eligible Senators
        while r_count and d_count:

            # Pop the senator with turn
            curr = q.popleft()

            # If eligible, float the ban on the other party, enqueue again.
            # If not, decrement the floating ban and count of the party.
            if curr == 'D':
                if d_floating_ban:
                    d_floating_ban -= 1
                    d_count -= 1
                else:
                    r_floating_ban += 1
                    q.append('D')
            else:
                if r_floating_ban:
                    r_floating_ban -= 1
                    r_count -= 1
                else:
                    d_floating_ban += 1
                    q.append('R')

        # Return the party with eligible Senators
        return 'Radiant' if r_count else 'Dire'