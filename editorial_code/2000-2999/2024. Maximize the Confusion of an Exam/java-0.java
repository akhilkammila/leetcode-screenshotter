class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int n = answerKey.length();
        int left = k, right = n;
        
        while (left < right) {
            int mid = (left + right + 1) / 2;
            
            if (isValid(answerKey, mid, k)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        
        return left;
    }
    
    private boolean isValid(String answerKey, int size, int k) {
        int n = answerKey.length();
        Map<Character, Integer> counter = new HashMap<>();
        
        for (int i = 0; i < size; i++) {
            char c = answerKey.charAt(i);
            counter.put(c, counter.getOrDefault(c, 0) + 1);
        }
        
        if (Math.min(counter.getOrDefault('T', 0), counter.getOrDefault('F', 0)) <= k) {
            return true;
        }
        
        for (int i = size; i < n; i++) {
            char c1 = answerKey.charAt(i);
            counter.put(c1, counter.getOrDefault(c1, 0) + 1);
            char c2 = answerKey.charAt(i - size);
            counter.put(c2, counter.getOrDefault(c2, 0) - 1);
            
            if (Math.min(counter.getOrDefault('T', 0), counter.getOrDefault('F', 0)) <= k) {
                return true;
            }
        }
        
        return false;
    }
}
