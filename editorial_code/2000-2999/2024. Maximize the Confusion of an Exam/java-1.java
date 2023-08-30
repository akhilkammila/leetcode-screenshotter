class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int maxSize = k;
        Map<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < k; i++) {
            count.put(answerKey.charAt(i), count.getOrDefault(answerKey.charAt(i), 0) + 1);
        }
        
        int left = 0;
        for (int right = k; right < answerKey.length(); right++) {
            count.put(answerKey.charAt(right), count.getOrDefault(answerKey.charAt(right), 0) + 1);
            
            while (Math.min(count.getOrDefault('T', 0), count.getOrDefault('F', 0)) > k) {
                count.put(answerKey.charAt(left), count.get(answerKey.charAt(left)) - 1);
                left++;
            }
            
            maxSize = Math.max(maxSize, right - left + 1);
        }
                    
        return maxSize;
    }
}