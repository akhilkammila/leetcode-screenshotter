class TimeMap:
    def __init__(self):
        self.key_time_map = {}

    def set(self, key: str, value: str, timestamp: int) -> None:
        # If the 'key' does not exist in dictionary.
        if not key in self.key_time_map:
            self.key_time_map[key] = {}
            
        # Store '(timestamp, value)' pair in 'key' bucket.
        self.key_time_map[key][timestamp] = value
        

    def get(self, key: str, timestamp: int) -> str:
        # If the 'key' does not exist in dictionary we will return empty string.
        if not key in self.key_time_map:
            return ""
        
        # Iterate on time from 'timestamp' to '1'.
        for curr_time in reversed(range(1, timestamp + 1)):
            # If a value for current time is stored in key's bucket we return the value.
            if curr_time in self.key_time_map[key]:
                return self.key_time_map[key][curr_time]
            
        # Otherwise no time <= timestamp was stored in key's bucket.
        return ""