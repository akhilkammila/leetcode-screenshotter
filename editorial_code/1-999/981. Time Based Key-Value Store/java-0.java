class TimeMap {
    HashMap<String, HashMap<Integer, String>> keyTimeMap;
    public TimeMap() {
        keyTimeMap = new HashMap<String, HashMap<Integer, String>>();
    }
    
    public void set(String key, String value, int timestamp) {
        // If the 'key' does not exist in map.
        if (!keyTimeMap.containsKey(key)) {
            keyTimeMap.put(key, new HashMap<Integer, String>());
        }
        
        // Store '(timestamp, value)' pair in 'key' bucket.
        keyTimeMap.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        // If the 'key' does not exist in map we will return empty string.
        if (!keyTimeMap.containsKey(key)) {
            return "";
        }
        
        // Iterate on time from 'timestamp' to '1'.
        for (int currTime = timestamp; currTime >= 1; --currTime) {
            // If a value for current time is stored in key's bucket we return the value.
            if (keyTimeMap.get(key).containsKey(currTime)) {
                return keyTimeMap.get(key).get(currTime);
            }
        }
        
        // Otherwise no time <= timestamp was stored in key's bucket.
        return ""; 
    }
}