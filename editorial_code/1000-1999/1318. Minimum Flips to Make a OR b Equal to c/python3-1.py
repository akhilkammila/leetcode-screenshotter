# In 3.9 or earlier
class Solution:
    # In 3.9 or earlier
    def minFlips(self, a: int, b: int, c: int) -> int:
        return bin((a | b) ^ c).count("1") + bin(a & b & ((a | b) ^ c)).count("1")

    # In 3.10 or later
    def minFlips(self, a: int, b: int, c: int) -> int:
        return ((a | b) ^ c).bit_count() + (a & b & ((a | b) ^ c)).bit_count()