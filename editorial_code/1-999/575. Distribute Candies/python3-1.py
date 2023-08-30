class Solution:
    def distributeCandies(self, candyType: List[int]) -> int:
        # We start by sorting candyType.
        candyType.sort()
        # The first candy is always unique.
        unique_candies = 1
        # For each candy, starting from the *second* candy...
        for i in range(1, len(candyType)):
            # This candy is unique if it is different to the one
            # immediately before it.
            if candyType[i] != candyType[i - 1]:
                unique_candies += 1
            # Optimization: We should terminate the loop if unique_candies
            # is now at the maxium she can eat.
            if unique_candies == len(candyType) // 2:
                break
        # Like before, the answer is the minimum out of the number of unique candies, and 
        # half the length of the candyType array.
        return min(unique_candies, len(candyType) // 2)