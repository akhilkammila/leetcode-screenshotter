def reorganize_string(s)
    char_counts = s.chars.tally
    max_count, letter = 0, ''
    char_counts.each do |char, count|
      if count > max_count
        max_count = count
        letter = char
      end
    end
    return "" if max_count > (s.length + 1) / 2
    ans = Array.new(s.length)
    index = 0

    # Place the most frequent letter
    while char_counts[letter] != 0
      ans[index] = letter
      index += 2
      char_counts[letter] -= 1
    end

    # Place rest of the letters in any order
    char_counts.each do |char, count|
      while count > 0
        if index >= s.length
          index = 1
        end
        ans[index] = char
        index += 2
        count -= 1
      end
    end

    return ans.join('')
end