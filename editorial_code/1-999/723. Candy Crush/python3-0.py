class Solution:
    def candyCrush(self, board: List[List[int]]) -> List[List[int]]:
        m, n = len(board), len(board[0])

        def find():
            crushed_set = set()

            # Check vertically adjacent candies 
            for r in range(1, m - 1):
                for c in range(n):
                    if board[r][c] == 0:
                        continue
                    if board[r][c] == board[r - 1][c] == board[r + 1][c]: 
                        crushed_set.add((r, c))
                        crushed_set.add((r - 1, c))
                        crushed_set.add((r + 1, c))

            # Check horizontally adjacent candies 
            for r in range(m):
                for c in range(1, n - 1):
                    if board[r][c] == 0:
                        continue
                    if board[r][c] == board[r][c - 1] == board[r][c + 1]:
                        crushed_set.add((r, c))
                        crushed_set.add((r, c - 1))
                        crushed_set.add((r, c + 1))
            return crushed_set
        
        # Set the value of each candies to be crushed as 0
        def crush(crushed_set):
            for (r, c) in crushed_set:
                board[r][c] = 0
        
        def drop():
            for c in range(n):
                lowest_zero = -1

                # Iterate over each column
                for r in range(m - 1, -1, -1):
                    if board[r][c] == 0:
                        lowest_zero = max(lowest_zero, r)

                    # Swap current non-zero candy with the lowest zero.
                    elif lowest_zero >= 0:
                        board[r][c], board[lowest_zero][c] = board[lowest_zero][c], board[r][c]
                        lowest_zero -= 1

        # Continue with the three steps until we can no longer find any crushable candies.
        crushed_set = find()
        while crushed_set:
            crush(crushed_set)
            drop()
            crushed_set = find()

        return board