class Solution {
public:
    char slowestKey(vector<int>& releaseTimes, string keysPressed) {
        int n = releaseTimes.size();
        int longestPress = releaseTimes[0];
        char slowestKey = keysPressed[0];
        for (int i = 1; i < n; i++) {
            int currentDuration = releaseTimes[i] - releaseTimes[i - 1];
            // check if we found the key that is slower than slowestKey
            if (currentDuration > longestPress ||
                (currentDuration == longestPress &&
                 keysPressed[i] > slowestKey)) {
                // update the slowest key and longest press duration
                longestPress = currentDuration;
                slowestKey = keysPressed[i];
            }
        }
        return slowestKey;
    }
};