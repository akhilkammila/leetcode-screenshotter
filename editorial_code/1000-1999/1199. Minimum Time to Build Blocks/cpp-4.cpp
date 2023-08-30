class Solution {
public:
    int minBuildTime(vector<int>& blocks, int split) {        
        // Sort Array in Descending Order of the required time
        sort(blocks.begin(), blocks.end(), greater<int>());
        
        // If can be built in "limit" 
        auto possible = [&](int limit) {           
            // Build all blocks starting with one worker
            int worker = 1;
            
            for (int i = 0; i < blocks.size(); i++) {
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
                    if (worker >= blocks.size() - i) {
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
        int right = split * (ceil(log2(blocks.size()))) + blocks[0];
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (possible(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return right;
    }
};