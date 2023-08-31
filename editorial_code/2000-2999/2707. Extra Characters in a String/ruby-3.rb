class TrieNode
  attr_accessor :children, :is_word

  def initialize
    @children = {}
    @is_word = false
  end
end

def min_extra_char(s, dictionary)
  n = s.length
  root = build_trie(dictionary)
  dp = Array.new(n + 1, 0)

  (n - 1).downto(0) do |start|
    dp[start] = dp[start + 1] + 1
    node = root
    start.upto(n - 1) do |last|
      unless node.children.key?(s[last])
        break
      end
      node = node.children[s[last]]
      if node.is_word
        dp[start] = [dp[start], dp[last + 1]].min
      end
    end
  end

  dp[0]
end

def build_trie(dictionary)
  root = TrieNode.new
  dictionary.each do |word|
    node = root
    word.each_char do |char|
      node.children[char] ||= TrieNode.new
      node = node.children[char]
    end
    node.is_word = true
  end
  root
end