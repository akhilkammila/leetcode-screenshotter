class Solution:
    def findDuplicateSubtrees(self, root):
        def traverse(node):
            if not node:
                return 0
            triplet = (traverse(node.left), node.val, traverse(node.right))
            if triplet not in triplet_to_id:
                triplet_to_id[triplet] = len(triplet_to_id) + 1
            id = triplet_to_id[triplet]
            cnt[id] += 1
            if cnt[id] == 2:
                res.append(node)
            return id
        triplet_to_id = dict()
        cnt = collections.defaultdict(int)
        res = []
        traverse(root)
        return res