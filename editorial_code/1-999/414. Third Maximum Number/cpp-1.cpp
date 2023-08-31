class Solution {
public:
    int thirdMax(vector<int>& nums) {
        priority_queue<int, vector<int>, greater<int>> minHeap;
        unordered_set<int> taken;
        
        for (int index = 0; index < nums.size(); ++index) {
            // If current number was already taken, skip it.
            if (taken.count(nums[index])) {
                continue;
            }
            
            // If min heap already has three numbers in it.
            // Pop the smallest if current number is bigger than it.
            if (minHeap.size() == 3) {
                if (minHeap.top() < nums[index]) {
                    taken.erase(minHeap.top());
                    minHeap.pop();
                    
                    minHeap.push(nums[index]);
                    taken.insert(nums[index]);
                }
            } 
            // If min heap does not have three number we can push it.
            else {
                minHeap.push(nums[index]);
                taken.insert(nums[index]);
            }
        }
        
        // 'nums' has only one distinct element it will be the maximum.
        if (minHeap.size() == 1) {
            return minHeap.top();
        }
        // 'nums' has two distinct elements.
        else if (minHeap.size() == 2) {
            int firstNum = minHeap.top();
            minHeap.pop();
            return max(firstNum, minHeap.top());
        }
        
        return minHeap.top();
    }
};