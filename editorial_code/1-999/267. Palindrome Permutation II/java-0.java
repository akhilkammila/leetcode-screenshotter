public class Solution {
    Set < String > set = new HashSet < > ();
    public List < String > generatePalindromes(String s) {
        permute(s.toCharArray(), 0);
        return new ArrayList < String > (set);
    }
    public boolean isPalindrome(char[] s) {
        for (int i = 0; i < s.length; i++) {
            if (s[i] != s[s.length - 1 - i])
                return false;
        }
        return true;
    }
    public void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
    void permute(char[] s, int l) {
        if (l == s.length) {
            if (isPalindrome(s))
                set.add(new String(s));
        } else {
            for (int i = l; i < s.length; i++) {
                swap(s, l, i);
                permute(s, l + 1);
                swap(s, l, i);
            }
        }
    }
}

