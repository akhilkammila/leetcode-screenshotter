class Solution:
    def knightProbability(self, n: int, k: int, row: int, column: int) -> float:
        # Define possible directions for the knight's moves
        directions = [(1, 2), (1, -2), (-1, 2), (-1, -2),
                      (2, 1), (2, -1), (-2, 1), (-2, -1)]

        # Initialize the previous and current DP arrays
        prev_dp = [[0] * n for _ in range(n)]
        curr_dp = [[0] * n for _ in range(n)]

        # Set the probability of the starting position to 1
        prev_dp[row][column] = 1

        # Iterate over the number of moves
        for moves in range(1, k + 1):
            # Iterate over the cells on the chessboard
            for i in range(n):
                for j in range(n):
                    # Reset the probability for the current cell
                    curr_dp[i][j] = 0

                    # Iterate over possible directions
                    for direction in directions:
                        prev_i, prev_j = i - direction[0], j - direction[1]
                        # Check if the previous cell is within the chessboard
                        if 0 <= prev_i < n and 0 <= prev_j < n:
                            # Update the probability for the current cell
                            curr_dp[i][j] += prev_dp[prev_i][prev_j] / 8

            # Swap the previous and current DP arrays
            prev_dp, curr_dp = curr_dp, prev_dp

        # Calculate the total probability
        total_probability = sum(
            prev_dp[i][j]
            for i in range(n)
            for j in range(n)
        )
        return total_probability