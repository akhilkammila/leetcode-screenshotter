class Solution:
    def minimumDeleteSum(self, s1: str, s2: str) -> int:

        # Return minimum cost to make s1[0...i] and s2[0...j] equal
        def compute_cost(i, j):

            # If s1 is empty, then we need to delete all characters of s2
            if i < 0:
                delete_cost = 0
                for pointer in range(j+1):
                    delete_cost += ord(s2[pointer])
                return delete_cost
            
            # If s2 is empty, then we need to delete all characters of s1
            if j < 0:
                delete_cost = 0
                for pointer in range(i+1):
                    delete_cost += ord(s1[pointer])
                return delete_cost
            
            # Check s1[i] and s2[j]
            if s1[i] == s2[j]:
                return compute_cost(i-1, j-1)
            else:
                return min(
                    ord(s1[i]) + compute_cost(i-1, j),
                    ord(s2[j]) + compute_cost(i, j-1),
                    ord(s1[i]) + ord(s2[j]) + compute_cost(i-1, j-1)
                )
        
        # Call helper function for complete strings
        return compute_cost(len(s1)-1, len(s2)-1)