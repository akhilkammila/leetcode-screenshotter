class Solution {
public:
    bool find132pattern(vector<int>& nums) {
        vector<pair<int, int>> intervals;
        size_t min_point_after_last_peak_index = 0;
        for (size_t i = 1; i < nums.size(); i++) {
            // if we encounter a falling edge, then element i - 1 is a peak
            if (nums[i] < nums[i - 1]) {
                // make sure the peak occurs after the rising edge's minimum
                if (min_point_after_last_peak_index < i - 1) {
                    // nums[min_point_after_last_peak_index...(i-1)] is a valid rising peak
                    intervals.push_back({nums[min_point_after_last_peak_index], nums[i - 1]});
                }
                // the current element is the minimum for the next rising peak
                min_point_after_last_peak_index = i;
            }
            for (auto interval : intervals) {
                if (nums[i] > interval.first and nums[i] < interval.second) {
                    return true;
                }
            }
        }
        return false;
    }
};