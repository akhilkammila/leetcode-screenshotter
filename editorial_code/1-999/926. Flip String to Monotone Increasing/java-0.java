class Solution {
    public int minFlipsMonoIncr(String s) {
        int m = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '0') {
                ++m;
            }
        }
        int ans = m;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '0') {
                ans = Math.min(ans, --m);
            } else {
                ++m;
            }
        }
        return ans;
    }
}