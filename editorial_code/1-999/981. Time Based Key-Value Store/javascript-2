let keyTimeMap = {};
var TimeMap = function() { 
    keyTimeMap = {};
};

TimeMap.prototype.set = function(key, value, timestamp) {
    // If the 'key' does not exist in dictionary.
    if (!(key in keyTimeMap)) {
        keyTimeMap[key] = Array();
    }

    // Store '(timestamp, value)' pair in 'key' bucket.
    keyTimeMap[key].push([ timestamp, value ]);
};


TimeMap.prototype.get = function(key, timestamp) {
    // If the 'key' does not exist in dictionary we will return empty string.
    if (!(key in keyTimeMap)) {
        return "";
    }
    
    if (timestamp < keyTimeMap[key][0][0]) {
        return "";
    }
    
    let left = 0;
    let right = keyTimeMap[key].length;

    while (left < right) {
        let mid = Math.floor((left + right) / 2);
        if (keyTimeMap[key][mid][0] <= timestamp) {
            left = mid + 1;
        } else {
            right = mid;
        }
    }
    
    // If iterator points to first element it means, no time <= timestamp exists.
    if (right == 0) {
        return "";
    }

    return keyTimeMap[key][right - 1][1];
};