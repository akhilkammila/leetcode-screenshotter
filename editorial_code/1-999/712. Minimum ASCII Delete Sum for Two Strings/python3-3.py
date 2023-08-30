class Solution:
    def minimumDeleteSum(self, s1: str, s2: str) -> int:
        
        # Prepare the two-dimensional array
        m, n = len(s1), len(s2)
        compute_cost = [[0] * (n + 1) for _ in range(m + 1)]

        # Fill the base case values
        for i in range(1, m + 1):
            compute_cost[i][0] = compute_cost[i-1][0] + ord(s1[i-1])
        for j in range(1, n + 1):
            compute_cost[0][j] = compute_cost[0][j-1] + ord(s2[j-1])
        
        # Fill the remaining cells using the Bellman Equation
        for i in range(1, m + 1):
            for j in range(1, n + 1):
                if s1[i-1] == s2[j-1]:
                    compute_cost[i][j] = compute_cost[i-1][j-1]
                else:
                    compute_cost[i][j] = min(
                        ord(s1[i-1]) + compute_cost[i-1][j],
                        ord(s2[j-1]) + compute_cost[i][j-1]
                    )
        
        # Return the answer for entire input strings
        return compute_cost[m][n]