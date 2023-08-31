class TimeMap {
public:
    unordered_map<string, map<int, string>> keyTimeMap;
    TimeMap() {
    }
    
    void set(string key, string value, int timestamp) {
        // Store '(timestamp, value)' pair in 'key' bucket.
        keyTimeMap[key][timestamp] = value;
    }
    
    string get(string key, int timestamp) {
        // If the 'key' does not exist in map we will return empty string.
        if (keyTimeMap.find(key) == keyTimeMap.end()) {
            return "";
        }
        
        auto it = keyTimeMap[key].upper_bound(timestamp);
        // If iterator points to first element it means, no time <= timestamp exists.
        if (it == keyTimeMap[key].begin()) {
            return "";
        }
        
        // Return value stored at previous position of current iterator.
        return prev(it)->second;
    }
};