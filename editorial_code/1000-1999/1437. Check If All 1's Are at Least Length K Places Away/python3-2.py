class Solution:
    def kLengthApart(self, nums: List[int], k: int) -> bool:
        # convert binary array into int
        x = 0
        for num in nums:
            x = (x << 1) | num
        
        # base case
        if x == 0 or k == 0:
            return True
        
        # remove trailing zeros
        while x & 1 == 0:
            x = x >> 1
        
        while x != 1:
            # remove trailing 1-bit
            x = x >> 1
            
            # count trailing zeros
            count = 0
            while x & 1 == 0:
                x = x >> 1
                count += 1
                
            # number of zeros in-between 1-bits
            # should be greater than or equal to k
            if count < k:
                return False
        
        return True