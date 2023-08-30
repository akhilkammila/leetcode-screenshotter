class Solution:
    def findDuplicateSubtrees(self, root):
        def traverse(node):
            if not node:
                return ""
            representation = ("(" + traverse(node.left) + ")" + str(node.val)
                              + "(" + traverse(node.right) + ")")
            cnt[representation] += 1
            if cnt[representation] == 2:
                res.append(node)
            return representation
        cnt = collections.defaultdict(int)
        res = []
        traverse(root)
        return res