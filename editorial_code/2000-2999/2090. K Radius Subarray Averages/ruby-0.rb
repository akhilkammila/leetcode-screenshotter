def get_averages(nums, k)
    # When a single element is considered then its average will be the number itself only.
    return nums if k == 0

    n = nums.size
    averages = Array.new(n, -1)

    # Any index will not have 'k' elements in its left and right.
    return averages if 2 * k + 1 > n

    # Generate 'prefix' array for 'nums'.
    # 'prefix[i + 1]' will be sum of all elements of 'nums' from index '0' to 'i'.
    prefix = Array.new(n + 1, 0)
    nums.each_with_index { |num, i| prefix[i + 1] = prefix[i] + num }

    # We iterate only on those indices which have at least 'k' elements in their left and right.
    # i.e. indices from 'k' to 'n - k'
    (k...(n - k)).each do |i|
        left_bound = i - k
        right_bound = i + k
        sub_array_sum = prefix[right_bound + 1] - prefix[left_bound]
        average = sub_array_sum / (2 * k + 1)
        averages[i] = average
    end
    averages
end