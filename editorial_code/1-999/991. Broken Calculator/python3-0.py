class Solution:
    def brokenCalc(self, startValue: int, target: int) -> int:
        ans = 0
        while target > startValue:
            ans += 1
            if target % 2: target += 1
            else: target //= 2

        return ans + startValue - target