#include <vector>

class Solution {
private:
    static const long long MOD = 1e9 + 7;
    vector<long long> factorial;
    vector<long long> invFactorial;

    // Function to calculate power under modulo MOD
    long long power(long long base, int exponent) {
        long long result = 1;
        // Loop until exponent is not zero
        while (exponent > 0) {
            // If exponent is odd, multiply result with base
            if (exponent & 1) {
                result = (result * base) % MOD;
            }
            // Divide the exponent by 2 and square the base
            exponent >>= 1;
            base = (base * base) % MOD;
        }
        return result;
    }

    // Function to pre-calculate factorials and inverse factorials
    void precalculateFactorials(int n) {
        factorial.resize(n + 1);
        invFactorial.resize(n + 1);
        factorial[0] = invFactorial[0] = 1;
        // Calculate factorials and inverse factorials for each number up to 'n'
        for (int i = 1; i <= n; i++) {
            factorial[i] = (factorial[i - 1] * i) % MOD;
            // Inverse factorial calculated using Fermat's Little Theorem
            invFactorial[i] = power(factorial[i], MOD - 2);
        }
    }

public:
    int numMusicPlaylists(int n, int goal, int k) {
        // Pre-calculate factorials and inverse factorials
        precalculateFactorials(n);
        // Initialize variables for calculation
        int sign = 1;
        long long answer = 0;
        // Loop from 'n' down to 'k'
        for (int i = n; i >= k; i--) {
            // Calculate temporary result for this iteration
            long long temp = power(i - k, goal - k);
            temp = (temp * invFactorial[n - i]) % MOD;
            temp = (temp * invFactorial[i - k]) % MOD;
            // Add or subtract temporary result to/from answer
            answer = (answer + sign * temp + MOD) % MOD;
            // Flip sign for next iteration
            sign *= -1;
        }
        // Final result is n! * answer, all under modulo
        return (factorial[n] * answer) % MOD;
    }
};