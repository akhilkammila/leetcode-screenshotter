class Solution:
    def minimumDeleteSum(self, s1: str, s2: str) -> int:
        
        # Pre-compute sum of ASCII values of s1
        m = len(s1)
        s1_ascii_sum = [0] * m
        s1_ascii_sum[0] = ord(s1[0])
        for i in range(1, m):
            s1_ascii_sum[i] = ord(s1[i]) + s1_ascii_sum[i-1]

        # Pre-compute sum of ASCII values of s2
        n = len(s2)
        s2_ascii_sum = [0] * n
        s2_ascii_sum[0] = ord(s2[0])
        for i in range(1, n):
            s2_ascii_sum[i] = ord(s2[i]) + s2_ascii_sum[i-1]
        
        # Dictionary to store the result of each sub-problem
        saved_result = {}

        # Return minimum cost to make s1[0...i] and s2[0...j] equal
        def compute_cost(i, j):

            # If both strings are empty, then no deletion is required
            if i < 0 and j < 0:
                return 0
            
            # If any one string is empty, delete all characters of the other string
            if i < 0:
                return s2_ascii_sum[j]
            if j < 0:
                return s1_ascii_sum[i]
            
            # If already computed, then return the result
            if (i, j) in saved_result:
                return saved_result[(i, j)]
            
            # Call sub-problem depending on s1[i] and s2[j]
            # Save the computed result.
            if s1[i] == s2[j]:
                saved_result[(i, j)] = compute_cost(i-1, j-1)
                return saved_result[(i, j)]
            else:
                saved_result[(i, j)] = min(
                    ord(s1[i]) + compute_cost(i-1, j),
                    ord(s2[j]) + compute_cost(i, j-1)
                )
                return saved_result[(i, j)]
        
        # Return minimum deletion cost
        return compute_cost(m-1, n-1)