class Solution:
    def maxPower(self, s: str) -> int:
        count = 0
        max_count = 0
        previous = None
        for c in s:
            if c == previous:
                # if same as previous one, increase the count
                count += 1
            else:
                # else, reset the count
                previous = c
                count = 1
            max_count = max(max_count, count)
        return max_count