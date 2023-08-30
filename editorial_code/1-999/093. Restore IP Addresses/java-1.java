class Solution {
    private boolean isValid(String s, int start, int length) {
        return length == 1 || 
            (s.charAt(start) != '0' && 
             (length < 3 || 
              s.substring(start, start + length).compareTo("255") <= 0));
    }
    
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        for (int len1 = Math.max(1, s.length() - 9); 
             len1 <= 3 && len1 <= s.length() - 3; ++len1) {
            if (!isValid(s, 0, len1)) {
                continue;
            }
            
            for (int len2 = Math.max(1, s.length() - len1 - 6);
                 len2 <= 3 && len2 <= s.length() - len1 - 2; ++len2) {
                if (!isValid(s, len1, len2)) {
                    continue;
                }
                for (int len3 = Math.max(1, s.length() - len1 - len2 - 3);
                     len3 <= 3 && len3 <= s.length() - len1 - len2 - 1; ++len3) {
                    if (isValid(s, len1 + len2, len3) && 
                        isValid(s, len1 + len2 + len3, 
                                s.length() - len1 - len2 - len3)) {
                       ans.add(String.join(".", s.
                          substring(0, len1), 
                          s.substring(len1, len1 + len2), 
                          s.substring(len1 + len2, len1 + len2 + len3),
                          s.substring(len1 + len2 + len3)));
                    }
                }
            }
            
        } 
        return ans;   
    }
}