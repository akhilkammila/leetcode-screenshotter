class Solution {
public:
    int transform(int& x, int& a, int& b, int& c) {
        // Return the transformed result for element 'x'
        return (a * x * x) + (b * x) + c;
    }

    vector<int> sortTransformedArray(vector<int>& nums, int a, int b, int c) {
        vector<int> answer;
        int left = 0, right = nums.size() - 1;
        
        if (a < 0) {
            // When 'downward parabola' we will put the edge element (smaller elements) first.
            while (left <= right) {
                int leftTransformedVal = transform(nums[left], a, b, c);
                int rightTransformedVal = transform(nums[right], a, b, c);
                if (leftTransformedVal < rightTransformedVal) {
                    answer.push_back(leftTransformedVal);
                    left++;
                } else {
                    answer.push_back(rightTransformedVal);
                    right--;
                }
            }
        } else {
            while (left <= right) {
                // When 'upward parabola' or a 'straight line' 
                // we will put the edge element (bigger elements) first.
                int leftTransformedVal = transform(nums[left], a, b, c);
                int rightTransformedVal = transform(nums[right], a, b, c);
                if (leftTransformedVal > rightTransformedVal) {
                    answer.push_back(leftTransformedVal);
                    left++;
                } else {
                    answer.push_back(rightTransformedVal);
                    right--;
                }
            }
            // Reverse the decreasing 'answer' array.
            reverse(answer.begin(), answer.end());
        }
        return answer;
    }
};