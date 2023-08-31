class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        self.nodes_found = False

        def dfs(node):
            if not node:
              return node
            left, right = dfs(node.left), dfs(node.right)
            conditions = 0
            if node in (p, q):
              conditions += 1
            if left:
              conditions += 1
            if right:
              conditions += 1
            if conditions == 2:
              self.nodes_found = True

            if (left and right) or node in (p, q): return node
            return left or right

        ans = dfs(root)
        return ans if self.nodes_found else None