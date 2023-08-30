class Solution:
    def knightProbability(self, n: int, k: int, row: int, column: int) -> float:
        directions = [(1, 2), (1, -2), (-1, 2), (-1, -2),
                      (2, 1), (2, -1), (-2, 1), (-2, -1)]
        dp = [[[-1] * n for _ in range(n)] for _ in range(k + 1)]

        def calculate_dp(moves, i, j):
            # Base case
            if moves == 0:
                if i == row and j == column:
                    return 1
                else:
                    return 0

            # Check if the value has already been calculated
            if dp[moves][i][j] != -1:
                return dp[moves][i][j]

            dp[moves][i][j] = 0

            # Iterate over possible directions
            for direction in directions:
                prev_i = i - direction[0]
                prev_j = j - direction[1]

                # Boundary check
                if 0 <= prev_i < n and 0 <= prev_j < n:
                    dp[moves][i][j] += calculate_dp(moves - 1, prev_i, prev_j)
            dp[moves][i][j] /= 8

            return dp[moves][i][j]

        # Calculate the total probability
        total_probability = sum(
            calculate_dp(k, i, j)
            for i in range(n)
            for j in range(n)
        )

        return total_probability