class Solution {
    public int longestPalindrome(String[] words) {
        final int alphabetSize = 26;
        int[][] count = new int[alphabetSize][alphabetSize];
        for (String word : words) {
            count[word.charAt(0) - 'a'][word.charAt(1) - 'a']++;
        }
        int answer = 0;
        boolean central = false;
        for (int i = 0; i < alphabetSize; i++) {
            if (count[i][i] % 2 == 0) {
                answer += count[i][i];
            } else {
                answer += count[i][i] - 1;
                central = true;
            }
            for (int j = i + 1; j < alphabetSize; j++) {
            	answer += 2 * Math.min(count[i][j], count[j][i]);
            }
        }
        if (central) {
            answer++;
        }
        return 2 * answer;
    }
}