class Solution:
    def lengthOfLongestSubstringKDistinct(self, s: str, k: int) -> int:
        n = len(s)
        max_size = 0
        counter = collections.Counter()
        
        left = 0
        for right in range(n):
            counter[s[right]] += 1
            
            while len(counter) > k: 
                counter[s[left]] -= 1
                if counter[s[left]] == 0:
                    del counter[s[left]]
                left += 1
            
            max_size = max(max_size, right - left + 1)
                    
        return max_size