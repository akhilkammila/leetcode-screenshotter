class Solution:
    def nimGame(self, piles: List[int]) -> bool:
        nim_sum = 0
        for p in piles:
            nim_sum ^= p
        return nim_sum != 0
