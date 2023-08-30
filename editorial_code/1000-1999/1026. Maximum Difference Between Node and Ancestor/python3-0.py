class Solution:
    def maxAncestorDiff(self, root: TreeNode) -> int:
        if not root:
            return 0
        # record the required maximum difference
        self.result = 0

        def helper(node, cur_max, cur_min):
            if not node:
                return
            # update `result`
            self.result = max(self.result, abs(cur_max-node.val),
                              abs(cur_min-node.val))
            # update the max and min
            cur_max = max(cur_max, node.val)
            cur_min = min(cur_min, node.val)
            helper(node.left, cur_max, cur_min)
            helper(node.right, cur_max, cur_min)

        helper(root, root.val, root.val)
        return self.result