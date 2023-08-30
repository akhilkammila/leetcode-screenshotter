class Solution:
    def distributeCandies(self, candyType: List[int]) -> int:
        # We need to count how many unique candies are in the array.
        unique_candies = 0
        # For each candy, we're going to check whether or not we've already
        # seen a candy identical to it.
        for i in range(len(candyType)):
            # Check if we've already seen a candy the same as candyType[i].
            for j in range(0, i):
                # If this candy is the same as previous one, we don't need to 
                # check further.
                if candyType[i] == candyType[j]:
                    break
            # Confused? An "else" after a "for" is an awesome Python feature.
            # The code in the "else" only runs if the "for" loop runs without a break.
            # In this case, we know that if we didn't "break" out of the loop, then 
            # candyType[i] is unique.
            # https://docs.python.org/3/tutorial/controlflow.html#break-and-continue-statements-and-else-clauses-on-loops
            else:
                unique_candies += 1
        # The answer is the minimum out of the number of unique candies, and 
        # half the length of the candyType array.
        return min(unique_candies, len(candyType) // 2)