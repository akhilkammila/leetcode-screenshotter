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
  memo = {}

  dp = lambda do |start|
    return 0 if start == n
    return memo[start] if memo.key?(start)
    # To count this character as a left over character 
    # move to index 'start + 1'
    ans = dp.call(start + 1) + 1
    node = root
    (start...n).each do |last|
      unless node.children.key?(s[last])
        break
      end
      node = node.children[s[last]]
      if node.is_word
        ans = [ans, dp.call(last + 1)].min
      end
    end

    memo[start] = ans
  end

  dp.call(0)
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