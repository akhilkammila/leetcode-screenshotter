class Solution:
    def countRoutes(self, locations: List[int], start: int, finish: int, fuel: int) -> int:
        n = len(locations)
        dp = [[0] * (fuel + 1) for _ in range(n)]

        for i in range(fuel + 1):
            dp[finish][i] = 1

        for j in range(fuel + 1):
            for i in range(n):
                for k in range(n):
                    if k == i:
                        continue
                    if abs(locations[i] - locations[k]) <= j:
                        dp[i][j] = (dp[i][j] + dp[k][j - abs(
                            locations[i] - locations[k])]) % 1000000007

        return dp[start][fuel]