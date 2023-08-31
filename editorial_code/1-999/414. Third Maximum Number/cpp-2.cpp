class Solution {
public:
    int thirdMax(vector<int>& nums) {
        // Sorted set to keep elements in sorted order.
        set<int> sortedNums;
        
        // Iterate on all elements of 'nums' array.
        for (int& num : nums) {
            // Do not insert same element again.
            if (sortedNums.count(num)) {
                continue;
            }
            
            // If sorted set has 3 elements.
            if (sortedNums.size() == 3) {
                // And the smallest element is smaller than current element.
                if (*sortedNums.begin() < num) {
                    // Then remove the smallest element and push the current element.
                    sortedNums.erase(sortedNums.begin());
                    sortedNums.insert(num);
                }
                
            } 
            // Otherwise push the current element of nums array.
            else {
                sortedNums.insert(num);
            }
        }
        
        // If sorted set has three elements return the smallest among those 3.
        if (sortedNums.size() == 3) {
            return *sortedNums.begin();
        }
        
        // Otherwise return the biggest element of nums array.
        return *sortedNums.rbegin();
    }
};