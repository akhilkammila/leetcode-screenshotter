class Solution:
    ALPHABET_SIZE = 26
    MOD = 1000000007

    def numWays(self, words: List[str], target: str) -> int:
        target_length = len(target)
        word_length = len(words[0])
        char_occurrences = [[0] * word_length for _ in range(self.ALPHABET_SIZE)]
        for col in range(word_length):
            for word in words:
                char_occurrences[ord(word[col]) - ord('a')][col] += 1
        dp = [[-1] * (word_length + 1) for _ in range(target_length + 1)]

        def calculate_dp(length, col):
            if col == 0:
                return 1 if length == 0 else 0
            if dp[length][col] != -1:
                return dp[length][col]
            dp[length][col] = calculate_dp(length, col - 1)
            if length > 0:
                dp[length][col] += (
                    char_occurrences[ord(target[length - 1]) - ord('a')][col - 1]
                    * calculate_dp(length - 1, col - 1)
                )
            dp[length][col] %= self.MOD
            return dp[length][col]

        return calculate_dp(target_length, word_length)