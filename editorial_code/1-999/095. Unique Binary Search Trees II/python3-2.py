class Solution:
    def generateTrees(self, n: int) -> List[Optional[TreeNode]]:
        dp = [[] for _ in range(n + 1)]
        dp[0].append(None)

        for numberOfNodes in range(1, n + 1):
            for i in range(1, numberOfNodes + 1):
                j = numberOfNodes - i
                for left in dp[i - 1]:
                    for right in dp[j]:
                        root = TreeNode(i, left, self.clone(right, i))
                        dp[numberOfNodes].append(root)

        return dp[n]

    def clone(self, node: Optional[TreeNode], offset: int) -> Optional[TreeNode]:
        if not node:
            return None
        cloned_node = TreeNode(node.val + offset)
        cloned_node.left = self.clone(node.left, offset)
        cloned_node.right = self.clone(node.right, offset)
        return cloned_node