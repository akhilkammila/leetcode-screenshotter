class Solution {
public:
    int thirdMax(vector<int>& nums) {
        pair<int, bool> firstMax = {-1, false};
        pair<int, bool> secondMax = {-1, false};
        pair<int, bool> thirdMax = {-1, false};
        
        for (int& num : nums) {
            // If current number is already stored, skip it.
            if ((firstMax.second && firstMax.first == num) || 
                (secondMax.second && secondMax.first == num) || 
                (thirdMax.second && thirdMax.first == num)) {
                continue;
            }
            
            // If we never stored any variable in firstMax
            // or curr num is bigger than firstMax, then curr num is the biggest number.
            if (!firstMax.second || firstMax.first <= num) {
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = make_pair(num, true);
            }
            // If we never stored any variable in secondMax
            // or curr num is bigger than secondMax, then curr num is 2nd biggest number.
            else if (!secondMax.second || secondMax.first <= num) {
                thirdMax = secondMax;
                secondMax = make_pair(num, true);
            }
            // If we never stored any variable in thirdMax
            // or curr num is bigger than thirdMax, then curr num is 3rd biggest number.
            else if (!thirdMax.second || thirdMax.first <= num) {
                thirdMax = make_pair(num, true);
            }
        }
        
        // If third max was never updated, it means we don't have 3 distinct numbers.
        if (!thirdMax.second) {
            return firstMax.first;
        }
        
        return thirdMax.first;
    }
};