def count_negatives(grid)
    count = 0
    n = grid[0].size
    curr_row_negative_index = n - 1

    # Iterate on all rows of the matrix one by one.
    grid.each do |row|
        # Decrease 'curr_row_negative_index' so that it points to current row's last positive element.
        while curr_row_negative_index >= 0 && row[curr_row_negative_index] < 0
            curr_row_negative_index -= 1
        end
        # 'curr_row_negative_index' points to the last positive element,
        # which means 'n - (curr_row_negative_index + 1)' is the number of all negative elements.
        count += (n - (curr_row_negative_index + 1))
    end
    count
end