class Solution {
public:
    int largestAltitude(vector<int>& gain) {
        int currentAltitude = 0;
        // Highest altitude currently is 0.
        int highestPoint = currentAltitude;
        
        for (int altitudeGain : gain) {
            // Adding the gain in altitude to the current altitude.
            currentAltitude += altitudeGain;
            // Update the highest altitude.
            highestPoint = max(highestPoint, currentAltitude);
        }
        
        return highestPoint;
    }
};