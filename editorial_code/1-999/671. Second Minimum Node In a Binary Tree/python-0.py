class Solution(object):
    def findSecondMinimumValue(self, root):
        def dfs(node):
            if node:
                uniques.add(node.val)
                dfs(node.left)
                dfs(node.right)

        uniques = set()
        dfs(root)

        min1, ans = root.val, float('inf')
        for v in uniques:
            if min1 < v < ans:
                ans = v

        return ans if ans < float('inf') else -1