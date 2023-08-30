class Solution {
public:
    // Get the cost of making every element equals base.
    long long getCost(vector<int>& nums, vector<int>& cost, int base) {
        long long result = 0;
        for (int i = 0; i < nums.size(); ++i)
            result += 1L * abs(nums[i] - base) * cost[i];
        return result;
    }
    
    long long minCost(vector<int>& nums, vector<int>& cost) {
        // Initialize the left and the right boundary of the binary search.
        long long answer = getCost(nums, cost, nums[0]);
        int left = *min_element(nums.begin(), nums.end());
        int right = *max_element(nums.begin(), nums.end());
        
        // As shown in the previous picture, if F(mid) > F(mid + 1), then the minimum
        // is to the right of mid, otherwise, the minimum is to the left of mid.
        while (left < right) {
            int mid = (left + right) / 2;
            long long cost1 = getCost(nums, cost, mid);
            long long cost2 = getCost(nums, cost, mid + 1);
            answer = min(cost1, cost2);
            if (cost1 > cost2)
                left = mid + 1;
            else
                right = mid;
        }
        return answer;
    } 
};