class Solution {
    private boolean valid(String s, int start, int length) {
        return length == 1 || 
            (s.charAt(start) != '0' && 
             (length < 3 || 
              s.substring(start, start + length).compareTo("255") <= 0));
    }
    
    private void helper(String s, int startIndex, List<Integer> dots, List<String> ans) {
        final int remainingLength = s.length() - startIndex;
        final int remainingNumberOfIntegers = 4 - dots.size();
        if (remainingLength > remainingNumberOfIntegers * 3 || 
            remainingLength < remainingNumberOfIntegers) {
            return;
        }
        if (dots.size() == 3) {
            if (valid(s, startIndex, remainingLength)) {
                StringBuilder sb = new StringBuilder();
                int last = 0;
                for (Integer dot : dots) {
                    sb.append(s.substring(last, last + dot));
                    last += dot;
                    sb.append('.');
                }
                sb.append(s.substring(startIndex));
                ans.add(sb.toString());
            }
            return;
        }
        for (int curPos = 1; curPos <= 3 && curPos <= remainingLength; ++curPos) {
            // Append a dot at the current position.
            dots.add(curPos);
            // Try making all combinations with the remaining string.
            if (valid(s, startIndex, curPos)) {
                helper(s, startIndex + curPos, dots, ans);
            }
            // Backtrack, i.e. remove the dot to try placing it at the next position.
            dots.remove(dots.size() - 1);
        }
    }
    
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        helper(s, 0, new ArrayList<>(), ans);
        return ans;   
    }
}