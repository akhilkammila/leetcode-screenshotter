def count_negatives(grid)
    count = 0
    # Iterate on all elements of the matrix one by one.
    grid.each do |row|
        row.each do |element|
            # If the current element is negative, we count it.
            if element < 0
                count += 1
            end
        end
    end
    return count
end