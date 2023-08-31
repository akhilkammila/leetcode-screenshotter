class Solution {
public:
    double binaryExp(double x, long long n) {
        if (n == 0) {
            return 1;
        }
       
        // Handle case where, n < 0.
        if (n < 0) {
            n = -1 * n;
            x = 1.0 / x;
        }
       
        // Perform Binary Exponentiation.
        double result = 1;
        while (n) {
            // If 'n' is odd we multiply result with 'x' and reduce 'n' by '1'.
            if (n % 2 == 1) {
                result = result * x;
                n -= 1;
            }
            // We square 'x' and reduce 'n' by half, x^n => (x^2)^(n/2).
            x = x * x;
            n = n / 2;
        }
        return result;
    }

    double myPow(double x, int n) {
        return binaryExp(x, (long long) n);
    }
};