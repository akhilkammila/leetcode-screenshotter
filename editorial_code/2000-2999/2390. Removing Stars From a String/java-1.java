class Solution {
    public String removeStars(String s) {
        int j = 0;
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                answer.deleteCharAt(answer.length() - 1);
            } else {
                answer.append(s.charAt(i));
            }
        }
        return answer.toString();
    }
}