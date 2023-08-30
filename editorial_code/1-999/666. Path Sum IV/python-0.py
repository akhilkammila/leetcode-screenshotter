class Node(object):
    def __init__(self, val):
        self.val = val
        self.left = self.right = None

class Solution(object):
    def pathSum(self, nums):
        self.ans = 0
        root = Node(nums[0] % 10)

        for x in nums[1:]:
            depth, pos, val = x/100, x/10 % 10, x % 10
            pos -= 1
            cur = root
            for d in xrange(depth - 2, -1, -1):
                if pos < 2**d:
                    cur.left = cur = cur.left or Node(val)
                else:
                    cur.right = cur = cur.right or Node(val)

                pos %= 2**d

        def dfs(node, running_sum = 0):
            if not node: return
            running_sum += node.val
            if not node.left and not node.right:
                self.ans += running_sum
            else:
                dfs(node.left, running_sum)
                dfs(node.right, running_sum)

        dfs(root)
        return self.ans