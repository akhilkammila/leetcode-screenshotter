class Solution:
    def maximumBags(self, capacity: List[int], rocks: List[int], additionalRocks: int) -> int:
        # Sort bags by the remaining capacity.
        remaining_capacity = [cap - rock for cap, rock in zip(capacity, rocks)]
        remaining_capacity.sort()
        full_bags = 0
        
        # Iterate over sorted bags and fill them using additional rocks.
        for curr_capacity in remaining_capacity:
            # If we can fill the current one, fill it and move on.
            # Otherwise, stop the iteration.
            if additionalRocks >= curr_capacity:
                additionalRocks -= curr_capacity
                full_bags += 1
            else:
                break
        
        # Return `full_bags` after the iteration stops.
        return full_bags