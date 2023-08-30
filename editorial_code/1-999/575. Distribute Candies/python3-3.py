class Solution:
    def distributeCandies(self, candyType: List[int]) -> int:
        # Count the number of unique candies by creating a set with
        # candyType, and then taking its length.
        unique_candies = len(set(candyType))
        # And find the answer in the same way as before.
        return min(unique_candies, len(candyType) // 2)