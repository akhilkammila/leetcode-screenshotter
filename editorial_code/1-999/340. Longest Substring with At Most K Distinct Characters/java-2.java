class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int n = s.length();
        int maxSize = 0;
        Map<Character, Integer> counter = new HashMap<>();
        
        for (int right = 0; right < n; right++) {
            counter.put(s.charAt(right), counter.getOrDefault(s.charAt(right), 0) + 1);
            
            if (counter.size() <= k) {
                maxSize++;
            } else {
                counter.put(s.charAt(right - maxSize), counter.get(s.charAt(right - maxSize)) - 1);
                if (counter.get(s.charAt(right - maxSize)) == 0) {
                    counter.remove(s.charAt(right - maxSize));
                }
            }
        }

        return maxSize; 
    }
}