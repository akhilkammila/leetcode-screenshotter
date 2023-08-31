def reorganize_string(s)
    ans = []
    pq = Heap.new
    # Min heap ordered by character counts, so we will use
    # negative values for count
    s.chars.group_by(&:itself).transform_values(&:size).each do |char, count|
        pq.push([-count, char])
    end

    while !pq.empty?
        count_first, char_first = pq.pop

        if ans.empty? || char_first != ans[-1]
            ans << char_first
            pq.push([count_first + 1, char_first]) unless count_first + 1 == 0
        else
            return '' if pq.empty?
            
            count_second, char_second = pq.pop
            ans << char_second
            pq.push([count_second + 1, char_second]) unless count_second + 1 == 0
            pq.push([count_first, char_first])
        end
    end
  
  ans.join('')
end