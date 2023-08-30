class TimeMap {
public:
    unordered_map<string, unordered_map<int, string>> keyTimeMap;
    TimeMap() {
    }
    
    void set(string key, string value, int timestamp) {
        // Store '(timestamp, value)' pair in 'key' bucket.
        keyTimeMap[key][timestamp] = value;
    }
    
    string get(string key, int timestamp) {
        // If the 'key' does not exist in map we will return empty string.
        if (!keyTimeMap.count(key)) {
            return "";
        }
        
        // Iterate on time from 'timestamp' to '1'.
        for (int currTime = timestamp; currTime >= 1; --currTime) {
            // If a value for current time is stored in key's bucket we return the value.
            if (keyTimeMap[key].count(currTime)) {
                return keyTimeMap[key][currTime];
            }
        }
        
        // Otherwise no time <= timestamp was stored in key's bucket.
        return "";
    }
};