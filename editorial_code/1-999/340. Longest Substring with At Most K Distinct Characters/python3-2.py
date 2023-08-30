class Solution:
    def lengthOfLongestSubstringKDistinct(self, s: str, k: int) -> int:
        max_size = 0
        counter = collections.Counter()
        
        for right in range(len(s)):
            counter[s[right]] += 1
            
            if len(counter) <= k:
                max_size += 1
            else:
                counter[s[right - max_size]] -= 1
                if counter[s[right - max_size]] == 0:
                    del counter[s[right - max_size]]

        return max_size