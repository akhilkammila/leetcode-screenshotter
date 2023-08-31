def count_negatives(grid)
    count = 0
    n = grid[0].size
    # Iterate on all rows of the matrix one by one.
    grid.each do |row|
        # Using binary search find the index
        # which has the first negative element.
        index = row.bsearch_index { |x| x < 0 } || n
        # 'index' points to the first negative element,
        # which means 'n - index' is the number of all negative elements.
        count += (n - index)
    end
    count
end