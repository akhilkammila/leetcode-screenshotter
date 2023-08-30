class Solution:
    def longestPalindrome(self, words: List[str]) -> int:
        # a count variable contains the number of occurrences of each word
        count = Counter(words)
        answer = 0
        central = False
        for word, count_of_the_word in count.items():
            # if the word is a palindrome
            if word[0] == word[1]:
                if count_of_the_word % 2 == 0:
                    answer += count_of_the_word
                else:
                    answer += count_of_the_word - 1
                    central = True
            # consider a pair of non-palindrome words,
            # such that one is the reverse of another
            # word[1] + word[0] is the reversed word
            elif word[0] < word[1]:
                answer += 2 * min(count_of_the_word, count[word[1] + word[0]])
        if central:
            answer += 1
        return 2 * answer