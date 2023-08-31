class Solution:
    def predictPartyVictory(self, senate: str) -> str:
        
        # Number of Senator
        n = len(senate)

        # Queues with Senator's Index.
        # Index will be used to find the next turn of Senator
        r_queue = deque()
        d_queue = deque()

        # Populate the Queues
        for i, s in enumerate(senate):
            if s == 'R':
                r_queue.append(i)
            else:
                d_queue.append(i)

        # While both parties have at least one Senator
        while r_queue and d_queue:
            
            # Pop the Next-Turn Senate from both Q.
            r_turn = r_queue.popleft()
            d_turn = d_queue.popleft()

            # ONE having a larger index will be banned by a lower index
            # Lower index will again get Turn, so EN-Queue again
            # But ensure its turn comes in the next round only
            if d_turn < r_turn:
                d_queue.append(d_turn + n)
            else:
                r_queue.append(r_turn + n)
        
        # One's which Empty is not the winner
        return "Radiant" if r_queue else "Dire"