class Solution:
    def largestAltitude(self, gain: List[int]) -> int:
        current_altitude = 0
        # Highest altitude currently is 0.
        highest_point = current_altitude
        
        for altitude_gain in gain:
            # Adding the gain in altitude to the current altitude.
            current_altitude += altitude_gain
            # Update the highest altitude.
            highest_point = max(highest_point, current_altitude)
        
        return highest_point