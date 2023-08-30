class Solution {
    public int minBuildTime(int[] blocks, int split) {        
        // Sort Array in Descending Order of the required time
        Arrays.sort(blocks);
        for (int i = 0; i < blocks.length / 2; i++) {
            int temp = blocks[i];
            blocks[i] = blocks[blocks.length - i - 1];
            blocks[blocks.length - i - 1] = temp;
        }
        
        // If can be built in "limit" 
        Predicate<Integer> possible = (limit) -> {           
            // Build all blocks starting with one worker
            int worker = 1;
            
            for (int i = 0; i < blocks.length; i++) {
                int time = blocks[i];                
                // If no worker or no sufficient time
                if (worker <= 0 || time > limit) {
                    return false;
                }
                
                // Keep splitting and producing workers as long as 
                // we are within the limit for this block
                while (time + split <= limit) {
                    limit -= split;
                    worker <<= 1;
                    
                    // Sufficient worker for remaining block
                    if (worker >= blocks.length - i) {
                        return true;
                    }
                }
                
                // Build Block
                worker --;
            }
            
            // All blocks build
            return true;
        };
        
        // Binary Search Algorithm
        int left = blocks[0];
        int right = split * (int) (Math.ceil(Math.log(blocks.length) / Math.log(2))) + blocks[0];
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (possible.test(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return right;
    }
}