class Solution:
    def numWays(self, words: List[str], target: str) -> int:
        ALPHABET_SIZE = 26
        MOD = 1000000007
        target_length = len(target)
        word_length = len(words[0])
        char_occurrences = [[0] * word_length for _ in range(ALPHABET_SIZE)]

        for col in range(word_length):
            for word in words:
                char_occurrences[ord(word[col]) - ord('a')][col] += 1

        dp = [[0] * (word_length + 1) for _ in range(target_length + 1)]
        dp[0][0] = 1

        for length in range(target_length + 1):
            for col in range(word_length):
                if length < target_length:
                    dp[length + 1][col + 1] += (
                        char_occurrences[ord(target[length]) - ord('a')][col] *
                        dp[length][col]
                    )
                    dp[length + 1][col + 1] %= MOD

                dp[length][col + 1] += dp[length][col]
                dp[length][col + 1] %= MOD

        return dp[target_length][word_length]
