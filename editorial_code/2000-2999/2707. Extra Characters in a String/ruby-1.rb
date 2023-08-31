def min_extra_char(s, dictionary)
  n = s.length
  dictionary_set = dictionary.to_set
  dp = Array.new(n + 1, 0)

  (n - 1).downto(0) do |start|
    dp[start] = dp[start + 1] + 1
    (start..n - 1).each do |last|
      curr = s[start...last + 1]
      if dictionary_set.include?(curr)
        dp[start] = [dp[start], dp[last + 1]].min
      end
    end
  end

  dp[0]
end