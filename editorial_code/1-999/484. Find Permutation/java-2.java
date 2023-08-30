public class Solution {
    public int[] findPermutation(String s) {
        int[] res = new int[s.length() + 1];
        res[0]=1;
        int i = 1;
        while (i <= s.length()) {
            res[i]=i+1;
            int j = i;
            if(s.charAt(i-1)=='D')
            {
                while (i <= s.length() && s.charAt(i - 1) == 'D')
                    i++;
                for (int k = j - 1, c = i; k <= i - 1; k++, c--) {
                    res[k] = c;
                }
            }
            else
                i++;
        }
        return res;
    }
}