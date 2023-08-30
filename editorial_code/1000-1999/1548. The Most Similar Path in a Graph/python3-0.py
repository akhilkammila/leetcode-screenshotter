class Solution:
    def mostSimilar(self, n: int, roads: List[List[int]], names: List[str],
                    targetPath: List[str]) -> List[int]:
        dp = [[len(targetPath) + 1] * n for i in range(len(targetPath))]
        p = [[None] * n for i in range(len(targetPath))]
        # initialize DP
        dp[0] = [names[i] != targetPath[0] for i in range(n)]
        # calculate DP
        for i in range(1, len(targetPath)):
            for road in roads:
                # consider both edges (u, v) and (v, u)
                for j in range(2):
                    u = road[j]
                    v = road[j ^ 1]
                    cur = dp[i - 1][u] + (names[v] != targetPath[i])
                    if cur < dp[i][v]:
                        dp[i][v] = cur
                        p[i][v] = u
        # the last vertex in the path
        v = dp[-1].index(min(dp[-1]))
        ans = [v]
        for i in range(len(targetPath) - 1, 0, -1):
            # the previous vertex in the path
            v = p[i][v]
            ans.append(v)
        return reversed(ans)