class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        def dfs(node, target):
            if node == target:
                return True
            if node is None:
                return False
            return dfs(node.left, target) or dfs(node.right, target)

        def LCA(node, p, q):
            if node is None or node == p or node == q:
                return node
            left = LCA(node.left, p, q)
            right = LCA(node.right, p, q)
            if left and right:
              return node
            elif left:
              return left
            else:
              return right

        ans = LCA(root, p, q)
        if ans == p:  # check if q is in the subtree of p
            return p if dfs(p, q) else None
        elif ans == q:  # check if p is in the subtree of q
            return q if dfs(q, p) else None
        return ans