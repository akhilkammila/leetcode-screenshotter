public class Solution {
    public int smallestFactorization(int a) {
        if (a < 2)
            return a;
        long res = 0, mul = 1;
        for (int i = 9; i >= 2; i--) {
            while (a % i == 0) {
                a /= i;
                res = mul * i + res;
                mul *= 10;
            }
        }
        return a < 2 && res <= Integer.MAX_VALUE ? (int)res : 0;
    }
}