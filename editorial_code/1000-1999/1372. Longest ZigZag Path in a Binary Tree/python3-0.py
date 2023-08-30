class Solution:
    def longestZigZag(self, root: Optional[TreeNode]) -> int:
        self.pathLength = 0
        
        def dfs(node, goLeft, steps):
            if node:
                self.pathLength = max(self.pathLength, steps)
                if goLeft:
                    dfs(node.left, False, steps + 1)
                    dfs(node.right, True, 1)
                else:
                    dfs(node.left, False, 1)
                    dfs(node.right, True, steps + 1)
        
        dfs(root, False, 0)
        dfs(root, True, 0)
        return self.pathLength