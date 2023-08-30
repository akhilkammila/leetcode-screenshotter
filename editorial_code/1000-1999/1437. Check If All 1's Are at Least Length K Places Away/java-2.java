class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        // convert binary array into int
        int x = 0;
        for (int num : nums) {
            x = (x << 1) | num;    
        }
        
        // base case
        if (x == 0 || k == 0) {
            return true;    
        }
        
        // remove trailing zeros
        while ((x & 1) == 0) {
            x = x >> 1;    
        }
        
        while (x != 1) {
            // remove trailing 1-bit
            x = x >> 1;
            
            // count trailing zeros
            int count = 0;
            while ((x & 1) == 0) {
                x = x >> 1;
                ++count;    
            }
                
            // number of zeros in-between 1-bits
            // should be greater than or equal to k
            if (count < k) {
                return false;    
            }    
        }
        return true;
    }
}