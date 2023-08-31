def get_averages(nums, k)
    # When a single element is considered then its average will be the number itself only.
    return nums if k == 0

    n = nums.size
    averages = Array.new(n, -1)

    # Any index will not have 'k' elements in its left and right.
    return averages if 2 * k + 1 > n

    # First get the sum of first window of the 'nums' array.
    window_sum = nums.first(k * 2 + 1).sum
    averages[k] = window_sum / (k * 2 + 1)

    # Iterate on rest indices which have at least 'k' elements
    # on its left and right sides.
    for i in (k * 2 + 1)...n do
      # We remove the discarded element and add the new element to get current window sum.
      # 'i' is the index of new inserted element, and
      # 'i - (window size)' is the index of the last removed element.
      window_sum = window_sum - nums[i - k * 2 - 1] + nums[i]
      averages[i - k] = window_sum / (k * 2 + 1)
    end

    averages    
end