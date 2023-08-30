class Solution:
    def find132pattern(self, nums: List[int]) -> bool:
        intervals = []
        i = 1
        min_point_after_last_peak_index = 0
        for i in range(len(nums)):
            # if we encounter a falling edge, then element i - 1 is a peak
            if nums[i] < nums[i - 1]:
                # make sure the peak occurs after the rising edge's minimum
                if min_point_after_last_peak_index < i - 1:
                    # nums[min_point_after_last_peak_index...(i-1)] is a valid rising peak
                    intervals.append(
                        (nums[min_point_after_last_peak_index], nums[i - 1])
                    )
                # the current element is the minimum for the next rising peak
                min_point_after_last_peak_index = i
            for interval in intervals:
                if interval[0] < nums[i] < interval[1]:
                    return True
        return False