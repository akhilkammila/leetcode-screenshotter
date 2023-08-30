class Solution {
    public String licenseKeyFormatting(String s, int k) {
        int totalChars = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '-') {
                totalChars++;
            }
        }
        int sizeOfFirstGroup = (totalChars % k);
        if (sizeOfFirstGroup == 0) {
            sizeOfFirstGroup = k;
        }
        StringBuilder ans = new StringBuilder();
        int i = 0;
        int count = 0;
        
        while (i < s.length()) {
            if (count == sizeOfFirstGroup) {
                count = 0;
                break;
            }
            if (s.charAt(i) != '-') {
                count++;
                ans.append(Character.toUpperCase(s.charAt(i)));
            }
            i++;
        }
        /* This case will only appear if the value of k is greater than the total number 
           of alphanumeric characters in string s */
        if (i >= s.length()) {
            return ans.toString();
        }
        ans.append('-');
        while (i < s.length()) {
            if (s.charAt(i) != '-') {
                /* Whenever the count is equal to k, we put a '-' after each group */
                if (count == k) {
                    ans.append('-');
                    count = 0;
                }
                ans.append(Character.toUpperCase(s.charAt(i)));
                count++;
            }
            i++;
        }
        return ans.toString();
    }
}