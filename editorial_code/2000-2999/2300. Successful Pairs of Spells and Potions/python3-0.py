class Solution:
    def successfulPairs(self, spells: List[int], potions: List[int], success: int) -> List[int]:
        # Sort the potions array in increasing order.
        potions.sort()
        answer = []

        m = len(potions)
        maxPotion = potions[m - 1]

        for spell in spells:
            # Minimum value of potion whose product with current spell
            # will be at least success or more.
            minPotion = (success + spell - 1) // spell
            # Check if we don't have any potion which can be used.
            if minPotion > maxPotion:
                answer.append(0)
                continue
            # We can use the found potion, and all potion in its right
            # (as the right potions are greater than the found potion).
            index = bisect.bisect_left(potions, minPotion)
            answer.append(m - index)

        return answer