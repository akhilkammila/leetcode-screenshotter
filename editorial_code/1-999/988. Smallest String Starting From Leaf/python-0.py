class Solution(object):
    def smallestFromLeaf(self, root):
        self.ans = "~"

        def dfs(node, A):
            if node:
                A.append(chr(node.val + ord('a')))
                if not node.left and not node.right:
                    self.ans = min(self.ans, "".join(reversed(A)))

                dfs(node.left, A)
                dfs(node.right, A)
                A.pop()

        dfs(root, [])
        return self.ans