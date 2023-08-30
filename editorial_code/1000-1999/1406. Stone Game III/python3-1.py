class Solution:
    def stoneGameIII(self, stoneValue: List[int]) -> str:
        n = len(stoneValue)

        def f(i):
            if i == n:
                return 0
            result = stoneValue[i] - f(i + 1)
            if i + 2 <= n:
                result = max(result, stoneValue[i] + stoneValue[i + 1] - f(i + 2))
            if i + 3 <= n:
                result = max(result, stoneValue[i] + stoneValue[i + 1]
                            + stoneValue[i + 2] - f(i + 3))
            return result

        dif = f(0)
        if dif > 0:
            return "Alice"
        if dif < 0:
            return "Bob"
        return "Tie"