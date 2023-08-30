class Solution {
public:
    char slowestKey(vector<int>& releaseTimes, string keysPressed) {
        int durationArray[26] = {0};
        durationArray[keysPressed[0] - 'a'] = releaseTimes[0];
        // find and store the key pressed duration for each key
        for (int i = 1; i < releaseTimes.size(); i++) {
            int currentDuration = releaseTimes[i] - releaseTimes[i - 1];
            char currentKey = keysPressed[i];
            durationArray[currentKey - 'a'] =
                max(durationArray[currentKey - 'a'], currentDuration);
        }
        // initialize slowest key as 'z'
        int slowestKeyIndex = 25;
        // iterate from 'y' to 'a' to find slowest key
        for (int currentKey = 24; currentKey >= 0; currentKey--) {
            if (durationArray[currentKey] > durationArray[slowestKeyIndex]) {
                slowestKeyIndex = currentKey;
            }
        }
        return slowestKeyIndex + 'a';
    }
};