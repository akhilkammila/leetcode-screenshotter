class Solution:
    def knightProbability(self, n: int, k: int, row: int, column: int) -> float:
        # Define possible directions for the knight's moves
        directions = [(1, 2), (1, -2), (-1, 2), (-1, -2),
                      (2, 1), (2, -1), (-2, 1), (-2, -1)]

        # Initialize the dynamic programming table
        dp = [[[0] * n for _ in range(n)] for _ in range(k + 1)]
        dp[0][row][column] = 1

        # Iterate over the number of moves
        for moves in range(1, k + 1):
            # Iterate over the cells on the chessboard
            for i in range(n):
                for j in range(n):
                    # Iterate over possible directions
                    for direction in directions:
                        prev_i, prev_j = i - direction[0], j - direction[1]
                        # Check if the previous cell is within the chessboard
                        if 0 <= prev_i < n and 0 <= prev_j < n:
                            # Add the previous probability
                            dp[moves][i][j] += dp[moves - 1][prev_i][prev_j]
                    # Divide by 8
                    dp[moves][i][j] /= 8

        # Calculate total probability by summing probabilities for all cells
        total_probability = sum(
            dp[k][i][j]
            for i in range(n)
            for j in range(n)
        )
        return total_probability