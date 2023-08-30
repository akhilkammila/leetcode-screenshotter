class Solution {
    public String longestPalindrome(String s) {
        StringBuilder sPrime = new StringBuilder("#");
        for (char c: s.toCharArray()) {
            sPrime.append(c).append("#");
        }
        
        int n = sPrime.length();
        int[] palindromeRadii = new int[n];
        int center = 0;
        int radius = 0;
        
        for (int i = 0; i < n; i++) {
            int mirror = 2 * center - i;
            
            if (i < radius) {
                palindromeRadii[i] = Math.min(radius - i, palindromeRadii[mirror]);
            }
            
            while (i + 1 + palindromeRadii[i] < n &&
                   i - 1 - palindromeRadii[i] >= 0 &&
                   sPrime.charAt(i + 1 + palindromeRadii[i]) == sPrime.charAt(i - 1 - palindromeRadii[i])) {
                palindromeRadii[i]++;
            }
            
            if (i + palindromeRadii[i] > radius) {
                center = i;
                radius = i + palindromeRadii[i];
            }
        }
        
        int maxLength = 0;
        int centerIndex = 0;
        for (int i = 0; i < n; i++) {
            if (palindromeRadii[i] > maxLength) {
                maxLength = palindromeRadii[i];
                centerIndex = i;
            }
        }
        
        int startIndex = (centerIndex - maxLength) / 2;
        String longestPalindrome = s.substring(startIndex, startIndex + maxLength);
        
        return longestPalindrome;
    }
}