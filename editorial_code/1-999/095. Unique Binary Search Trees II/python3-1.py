class Solution:
    def generateTrees(self, n: int) -> List[TreeNode]:
        dp = [[[] for _ in range(n + 1)] for _ in range(n + 1)]
        for i in range(1, n + 1):
            dp[i][i] = [TreeNode(i)]

        for numberOfNodes in range(2, n + 1):
            for start in range(1, n - numberOfNodes + 2):
                end = start + numberOfNodes - 1
                for i in range(start, end + 1):
                    left_subtrees = dp[start][i - 1] if i != start else [None]
                    right_subtrees = dp[i + 1][end] if i != end else [None]

                    for left in left_subtrees:
                        for right in right_subtrees:
                            root = TreeNode(i, left, right)
                            dp[start][end].append(root)

        return dp[1][n]