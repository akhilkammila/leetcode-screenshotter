class Solution {

    public String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        int lastSpaceIndex = -1;
        for (int strIndex = 0; strIndex < s.length(); strIndex++) {
            if ((strIndex == s.length() - 1) || s.charAt(strIndex) == ' ') {
                int reverseStrIndex = (strIndex == s.length() - 1) ? strIndex : strIndex - 1;
                for (; reverseStrIndex > lastSpaceIndex; reverseStrIndex--) {
                    result.append(s.charAt(reverseStrIndex));
                }
                if (strIndex != s.length() - 1) {
                    result.append(' ');
                }
                lastSpaceIndex = strIndex;
            }
        }
        return new String(result);
    }
}