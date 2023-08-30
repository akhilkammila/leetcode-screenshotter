class Solution:
    def kLengthApart(self, nums: List[int], k: int) -> bool:
        # initialize the counter of zeros to k
        # to pass the first 1 in nums
        count = k
        
        for num in nums:
            # if the current integer is 1
            if num == 1:
                # check that number of zeros in-between 1s
                # is greater than or equal to k
                if count < k:
                    return False
                # reinitialize counter
                count = 0
            # if the current integer is 0
            else:
                # increase the counter
                count += 1
                
        return True