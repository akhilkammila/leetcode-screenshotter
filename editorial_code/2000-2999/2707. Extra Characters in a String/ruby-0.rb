def min_extra_char(s, dictionary)
  n = s.length
  dictionary_set = dictionary.to_set
  memo = {}

  dp = lambda do |start|
    return memo[start] if memo.key?(start)
    return 0 if start == n
    # To count this character as a left over character 
    # move to index 'start + 1'
    ans = dp.call(start + 1) + 1
    (start..n - 1).each do |last|
      curr = s[start...last + 1]
      if dictionary_set.include?(curr)
        ans = [ans, dp.call(last + 1)].min
      end
    end
    memo[start] = ans
  end

  dp.call(0)
end