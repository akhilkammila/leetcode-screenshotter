class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        all_letters = set(s)
        max_length = 0

        # iterate over each unique letter
        for letter in all_letters:
            start = 0
            count = 0

            # initialize a sliding window for each unique letter
            for end in range(len(s)):
                if s[end] == letter:
                    # if the letter matches, increase the count
                    count += 1

                # bring start forward until the window is valid again
                while not self.__is_window_valid(start, end, count, k):
                    if s[start] == letter:
                        # if the letter matches, decrease the count
                        count -= 1
                    start += 1

                # at this point the window is valid, update max_length
                max_length = max(max_length, end + 1 - start)

        return max_length

    def __is_window_valid(self, start: int, end: int, count: int, k: int):
        return end + 1 - start - count <= k