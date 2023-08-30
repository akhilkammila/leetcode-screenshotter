class Solution:
    def maxPoints(self, points: List[List[int]]) -> int:
        n = len(points[0])
        lastDp = points[0]
        for i in range(1, len(points)):
            currentDp = []
            temp = 0;
            for j in range(n):
                temp = max(temp, lastDp[j] + j)
                currentDp.append(temp - j + points[i][j])
            temp = -n;
            for j in reversed(range(n)):
                temp = max(temp, lastDp[j] - j)
                currentDp[j] = max(currentDp[j], temp + j + points[i][j])
            lastDp = currentDp
        return max(lastDp)