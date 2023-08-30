class Solution {
    public boolean rotateString(String A, String B) {
        if (A.length() != B.length())
            return false;
        if (A.length() == 0)
            return true;

        search:
            for (int s = 0; s < A.length(); ++s) {
                for (int i = 0; i < A.length(); ++i) {
                    if (A.charAt((s+i) % A.length()) != B.charAt(i))
                        continue search;
                }
                return true;
            }
        return false;
    }
}