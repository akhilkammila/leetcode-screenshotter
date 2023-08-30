class Solution:
    def candyCrush(self, board: List[List[int]]) -> List[List[int]]:
        m, n = len(board), len(board[0])

        def find_and_crush():
            complete = True

            # Check vertically adjacent candies 
            for r in range(1, m - 1):
                for c in range(n):
                    if board[r][c] == 0:
                        continue
                    if abs(board[r][c]) == abs(board[r - 1][c]) == abs(board[r + 1][c]): 
                        board[r][c] = -abs(board[r][c])
                        board[r - 1][c] = -abs(board[r - 1][c])
                        board[r + 1][c] = -abs(board[r + 1][c])
                        complete = False

            # Check horizontally adjacent candies 
            for r in range(m):
                for c in range(1, n - 1):
                    if board[r][c] == 0:
                        continue
                    if abs(board[r][c]) == abs(board[r][c - 1]) == abs(board[r][c + 1]): 
                        board[r][c] = -abs(board[r][c])
                        board[r][c - 1] = -abs(board[r][c - 1])
                        board[r][c + 1] = -abs(board[r][c + 1])
                        complete = False
            
            # Set the value of each candies to be crushed as 0
            for r in range(m):
                for c in range(n):
                    if board[r][c] < 0:
                        board[r][c] = 0           
            return complete
        
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
        while not find_and_crush():
            drop()

        return board