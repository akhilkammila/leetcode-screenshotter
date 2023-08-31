def minimum_delete_sum(s1, s2)
  # Make sure s2 is the smaller string
  if s1.length < s2.length
    return minimum_delete_sum(s2, s1)
  end

  # Compute the base case for an empty s1
  m, n = s1.length, s2.length
  curr_row = Array.new(n + 1)
  curr_row[0] = 0
  for j in 1..n
    curr_row[j] = curr_row[j - 1] + s2[j - 1].ord
  end

  # Compute the answer row-by-row
  for i in 1..m
    diag = curr_row[0]
    curr_row[0] += s1[i - 1].ord

    for j in 1..n
      # If the characters are the same, the answer is the top-left diagonal value
      if s1[i - 1] == s2[j - 1]
        answer = diag
      else
        # Otherwise, the answer is the minimum of the top and left values with
        # the deleted character's ASCII value
        answer = [
          s1[i - 1].ord + curr_row[j],
          s2[j - 1].ord + curr_row[j - 1]
        ].min
      end

      # Before overwriting curr_row[j] with the answer, save it in diag
      # for the next column
      diag = curr_row[j]
      curr_row[j] = answer
    end
  end

  # Return the answer
  return curr_row[n]
end