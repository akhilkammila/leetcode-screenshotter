class Solution:
    def distributeCandies(self, candyType: List[int]) -> int:
        # We start by heapifying candyType.
        heapq.heapify(candyType)
        # We need to save this now, as we're going to be modifying candyType.
        maximum_candies_allowed = len(candyType) // 2
        unique_candies = 0
        # And now, remove elements off the heap until 
        while candyType and unique_candies < maximum_candies_allowed:
            # Take a candy off, we'll be checking if it is unique.
            candy = heapq.heappop(candyType)
            # If the next candy is not the same as this one, or there isn't a next
            # candy, then this candy must be unique.
            if not candyType or candyType[0] != candy:
                unique_candies += 1
        # Like before, the answer is the minimum out of the number of unique candies, and 
        # half the length of the candyType array.
        return min(unique_candies, maximum_candies_allowed)