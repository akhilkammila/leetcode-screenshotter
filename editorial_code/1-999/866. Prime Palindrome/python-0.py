class Solution(object):
    def primePalindrome(self, N):
        def is_prime(n):
            return n > 1 and all(n%d for d in xrange(2, int(n**.5) + 1))

        for length in xrange(1, 6):
            #Check for odd-length palindromes
            for root in xrange(10**(length - 1), 10**length):
                s = str(root)
                x = int(s + s[-2::-1]) #eg. s = '123' to x = int('12321')
                if x >= N and is_prime(x):
                    return x
                    #If we didn't check for even-length palindromes:
                    #return min(x, 11) if N <= 11 else x

            #Check for even-length palindromes
            for root in xrange(10**(length - 1), 10**length):
                s = str(root)
                x = int(s + s[-1::-1]) #eg. s = '123' to x = int('123321')
                if x >= N and is_prime(x):
                    return x