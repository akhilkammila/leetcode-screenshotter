class Solution:
    def longestPalindrome(self, words: List[str]) -> int:
        alphabet_size = 26
        count = [[0 for j in range(alphabet_size)] for i in range(alphabet_size)]
        for word in words:
            count[ord(word[0]) - ord('a')][ord(word[1]) - ord('a')] += 1
        answer = 0
        central = False
        for i in range(alphabet_size):
            if count[i][i] % 2 == 0:
                answer += count[i][i]
            else:
                answer += count[i][i] - 1
                central = True
            for j in range(i + 1, alphabet_size):
                answer += 2 * min(count[i][j], count[j][i])
        if central:
            answer += 1
        return 2 * answer