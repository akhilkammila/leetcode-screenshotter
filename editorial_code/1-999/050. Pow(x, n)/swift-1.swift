class Solution {
    func binaryExp(base x: Double, exponent n: Int) -> Double {
        guard n != 0 else {
            return 1
        }

        // Handle case where, n < 0.
        var x = x, n = n
        if n < 0 {
            n = -n
            x = 1.0 / x
        }

        // Perform Binary Exponentiation.
        var result = 1.0
        while n != 0 {
            // If 'n' is odd we multiply result with 'x' and reduce 'n' by '1'.
            if n % 2 == 1 {
                result *= x
                n -= 1
            }
            // We square 'x' and reduce 'n' by half, x^n => (x^2)^(n/2).
            x *= x
            n /= 2
        }
        return result
    }

    func myPow(_ x: Double, _ n: Int) -> Double {
        return binaryExp(base: x, exponent: n)
    }
}