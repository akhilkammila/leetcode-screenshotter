class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int n = s.length();
        int maxSize = 0;
        Map<Character, Integer> counter = new HashMap<>();
        
        int left = 0;
        for (int right = 0; right < n; right++) {
            counter.put(s.charAt(right), counter.getOrDefault(s.charAt(right), 0) + 1);
            
            while (counter.size() > k) {
                counter.put(s.charAt(left), counter.get(s.charAt(left)) - 1);
                if (counter.get(s.charAt(left)) == 0) {
                    counter.remove(s.charAt(left));
                }
                left++;
            }
            
            maxSize = Math.max(maxSize, right - left + 1);
        }
                    
        return maxSize;  
    }
}