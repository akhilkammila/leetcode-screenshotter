class Solution:
    MOD = 1_000_000_007

    def power(self, base, exponent):
        result = 1
        # Loop until exponent is not zero
        while exponent > 0:
            # If exponent is odd, multiply result with base
            if exponent & 1:
                result = (result * base) % self.MOD
            # Divide the exponent by 2 and square the base
            exponent >>= 1
            base = (base * base) % self.MOD
        return result

    def precalculate_factorials(self, n):
        self.factorial = [1] * (n + 1)
        self.inv_factorial = [1] * (n + 1)
        # Calculate factorials and inverse factorials for each number up to 'n'
        for i in range(1, n + 1):
            self.factorial[i] = (self.factorial[i - 1] * i) % self.MOD
            # Inverse factorial calculated using Fermat's Little Theorem
            self.inv_factorial[i] = self.power(self.factorial[i], self.MOD - 2)

    def numMusicPlaylists(self, n, goal, k):
        # Pre-calculate factorials and inverse factorials
        self.precalculate_factorials(n)
        # Initialize variables for calculation
        sign = 1
        answer = 0
        # Loop from 'n' down to 'k'
        for i in range(n, k - 1, -1):
            # Calculate temporary result for this iteration
            temp = self.power(i - k, goal - k)
            temp = (temp * self.inv_factorial[n - i]) % self.MOD
            temp = (temp * self.inv_factorial[i - k]) % self.MOD
            # Add or subtract temporary result to/from answer
            answer = (answer + sign * temp + self.MOD) % self.MOD
            # Flip sign for next iteration
            sign *= -1
        # Final result is n! * answer, all under modulo
        return (self.factorial[n] * answer) % self.MOD