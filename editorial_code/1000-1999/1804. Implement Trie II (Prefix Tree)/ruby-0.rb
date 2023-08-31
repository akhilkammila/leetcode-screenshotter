class TrieNode
    attr_accessor :links, :words_ending_here, :words_starting_here
    
    def initialize()
        @links = Array.new(26)
        @words_ending_here = 0
        @words_starting_here = 0
    end
end

class Trie
    def initialize()
        @root = TrieNode.new
    end

    def insert(word)
        node = @root
        word.each_char do |w|
            char_index = w.ord - 'a'.ord
            node.links[char_index] ||= TrieNode.new
            node = node.links[char_index]
            node.words_starting_here += 1
        end
        node.words_ending_here += 1
    end

    def count_words_equal_to(word)
        node = @root
        word.each_char do |w|
            char_index = w.ord - 'a'.ord
            return 0 if node.links[char_index].nil?
            node = node.links[char_index]
        end
        node.words_ending_here
    end

    def count_words_starting_with(prefix)
        node = @root
        prefix.each_char do |w|
            char_index = w.ord - 'a'.ord
            return 0 if node.links[char_index].nil?
            node = node.links[char_index]
        end
        node.words_starting_here
    end

    def erase(word)
        node = @root
        word.each_char do |w|
            char_index = w.ord - 'a'.ord
            node = node.links[char_index]
            node.words_starting_here -= 1
        end
        node.words_ending_here -= 1
    end
end