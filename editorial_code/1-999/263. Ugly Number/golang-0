func isUgly(n int) bool {    
    // A non-positive integer cannot be ugly
    if n <= 0 {
        return false
    }

    // Factorize by dividing with permitted factors.
    for _, factor := range []int{2, 3, 5} {
        n = keepDividingWhenDivisible(n, factor)
    }

    // Check if the integer is reduced to 1 or not.
    return n == 1
}

// Keep dividing dividend by divisor when division is possible.
func keepDividingWhenDivisible(dividend, divisor int) int {
    for dividend % divisor == 0 {
        dividend /= divisor;
    }
    return dividend
}