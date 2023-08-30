class Solution {
public:
    char slowestKey(vector<int>& releaseTimes, string keysPressed) {
        unordered_map<char, int> durationMap;
        durationMap[keysPressed[0]] = releaseTimes[0];
        // find and store the keypress duration for each key in the durationMap
        for (int i = 1; i < releaseTimes.size(); i++) {
            int currentDuration = releaseTimes[i] - releaseTimes[i - 1];
            char currentKey = keysPressed[i];
            durationMap[currentKey] =
                max(durationMap[currentKey], currentDuration);
        }
        char slowestKey = ' ';
        int longestPressDuration = 0;
        // iterate over the map to find the slowest key
        for (auto mapElement : durationMap) {
            char key = static_cast<char>(mapElement.first);
            int duration = static_cast<int>(mapElement.second);
            if (duration > longestPressDuration) {
                longestPressDuration = duration;
                slowestKey = key;
            } else if (duration == longestPressDuration && key > slowestKey) {
                slowestKey = key;
            }
        }
        return slowestKey;
    }
};