class Solution {
    func binaryExp(base x: Double, exponent n: Int) -> Double {
        // Base case, to stop recursive calls.
        guard n != 0 else {
            return 1
        }
       
        // Handle case where, n < 0.
        guard n > 0 else {
            return 1 / binaryExp(base: x, exponent: (-1 * n))
        }
       
        // Perform Binary Exponentiation.
        // If 'n' is odd we perform Binary Exponentiation on 'n - 1' and multiply result with 'x'.
        if n % 2 == 1 {
            return x * binaryExp(base: (x * x), exponent: ((n - 1) / 2))
        }
        // Otherwise we calculate result by performing Binary Exponentiation on 'n'.
        else {
            return binaryExp(base: (x * x), exponent: (n / 2))
        }
    }

    func myPow(_ x: Double, _ n: Int) -> Double {
        return binaryExp(base: x, exponent: n)
    }
}