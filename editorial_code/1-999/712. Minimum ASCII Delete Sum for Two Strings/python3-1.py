class Solution:
    def minimumDeleteSum(self, s1: str, s2: str) -> int:
    
        # Dictionary to store the result of each sub-problem
        saved_result = {}

        # Return minimum cost to make s1[0...i] and s2[0...j] equal
        def compute_cost(i, j):

            # If both strings are empty, then no deletion is required
            if i < 0 and j < 0:
                return 0
            
            # If already computed, then return the result from the dictionary
            if (i, j) in saved_result:
                return saved_result[(i, j)]
            
            # If any one string is empty, delete all characters of the other string
            if i < 0:
                saved_result[(i, j)] = ord(s2[j]) + compute_cost(i, j-1)
                return saved_result[(i, j)]
            if j < 0:
                saved_result[(i, j)] = ord(s1[i]) + compute_cost(i-1, j)
                return saved_result[(i, j)]
            
            # Call sub-problem depending on s1[i] and s2[j]
            # Save the computed result.
            if s1[i] == s2[j]:
                saved_result[(i, j)] = compute_cost(i-1, j-1)
            else:
                saved_result[(i, j)] = min(
                    ord(s1[i]) + compute_cost(i-1, j),
                    ord(s2[j]) + compute_cost(i, j-1)
                )

            return saved_result[(i, j)]

        # Return the result of the main problem
        return compute_cost(len(s1)-1, len(s2)-1)