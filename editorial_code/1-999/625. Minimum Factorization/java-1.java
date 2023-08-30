public class Solution {
    long ans;
    public int smallestFactorization(int a) {
        if(a < 2)
            return a;
        int[] dig=new int[]{9, 8, 7, 6, 5, 4, 3, 2};
        if (search(dig, 0, a, 1, "") && ans <= Integer.MAX_VALUE)
            return (int)ans;
        return 0;
    }
    public boolean search(int[] dig, int i, int a, long mul, String res) {
        if (mul > a || i == dig.length )
            return false;
        if (mul == a) {
            ans = Long.parseLong(res);
            return true;
        }
        return search(dig, i, a, mul * dig[i], dig[i] + res) || search(dig, i + 1, a, mul, res);
    }
}
