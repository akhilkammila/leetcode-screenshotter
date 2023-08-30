class Solution {
    public int primePalindrome(int N) {
        while (true) {
            if (N == reverse(N) && isPrime(N))
                return N;
            N++;
            
            // Any even length palindrome must be divisble by 11
            // so we will skip numbers N = [10,000,000, 99,999,999]
            if (10_000_000 < N && N < 100_000_000)
                N = 100_000_000;
        }
    }

    public boolean isPrime(int N) {
        if (N < 2) return false;
        int R = (int) Math.sqrt(N);
        for (int d = 2; d <= R; ++d)
            if (N % d == 0) return false;
        return true;
    }

    public int reverse(int N) {
        int ans = 0;
        while (N > 0) {
            ans = 10 * ans + (N % 10);
            N /= 10;
        }
        return ans;
    }
}
