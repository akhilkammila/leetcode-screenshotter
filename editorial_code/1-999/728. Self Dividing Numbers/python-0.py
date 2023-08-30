class Solution(object):
    def selfDividingNumbers(self, left, right):
        def self_dividing(n):
            for d in str(n):
                if d == '0' or n % int(d) > 0:
                    return False
            return True
        """
        Alternate implementation of self_dividing:
        def self_dividing(n):
            x = n
            while x > 0:
                x, d = divmod(x, 10)
                if d == 0 or n % d > 0:
                    return False
            return True
        """
        ans = []
        for n in range(left, right + 1):
            if self_dividing(n):
                ans.append(n)
        return ans #Equals filter(self_dividing, range(left, right+1))
