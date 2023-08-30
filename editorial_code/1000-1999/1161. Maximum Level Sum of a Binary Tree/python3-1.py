class Solution:
    def maxLevelSum(self, root: Optional[TreeNode]) -> int:
        def dfs(node: TreeNode, level: int, sum_at_current_level: List) -> None:
            if not node:
                return

            if len(sum_at_current_level) == level:
                sum_at_current_level.append(node.val)
            else:
                sum_at_current_level[level] += node.val

            dfs(node.left, level + 1, sum_at_current_level)
            dfs(node.right, level + 1, sum_at_current_level)

        sum_at_current_level = []    
        dfs(root, 0, sum_at_current_level)

        return 1 + sum_at_current_level.index(max(sum_at_current_level))