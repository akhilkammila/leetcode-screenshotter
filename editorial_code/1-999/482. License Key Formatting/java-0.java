class Solution {
    public String licenseKeyFormatting(String s, int k) {
        int count = 0;
        int n = s.length();
        StringBuilder ans = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) != '-') {
                ans.append(Character.toUpperCase(s.charAt(i)));
                count++;
                if (count == k) {
                    ans.append('-');
                    count = 0;
                }
            }
        }
        // Make sure that the last character is not a dash
        if (ans.length() > 0 && ans.charAt(ans.length()-1) == '-') { 
            ans = new StringBuilder(ans.substring(0, ans.length()-1));
        }
        // Reversing the string
        ans.reverse();
        return ans.toString();
    }
}