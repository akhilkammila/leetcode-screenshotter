class Solution:
    def isSubtree(self, root: TreeNode, subRoot: TreeNode) -> bool:

        MOD_1 = 1_000_000_007
        MOD_2 = 2_147_483_647

        def hash_subtree_at_node(node, need_to_add):
            if node is None:
                return (3, 7)

            left = hash_subtree_at_node(node.left, need_to_add)
            right = hash_subtree_at_node(node.right, need_to_add)

            left_1 = (left[0] << 5) % MOD_1
            right_1 = (right[0] << 1) % MOD_1
            left_2 = (left[1] << 7) % MOD_2
            right_2 = (right[1] << 1) % MOD_2

            hashpair = ((left_1 + right_1 + node.val) % MOD_1,
                        (left_2 + right_2 + node.val) % MOD_2)

            if need_to_add:
                memo.add(hashpair)

            return hashpair

        # List to store hashed value of each node.
        memo = set()

        # Calling and adding hash to List
        hash_subtree_at_node(root, True)

        # Storing hashed value of subRoot for comparison
        s = hash_subtree_at_node(subRoot, False)

        # Check if hash of subRoot is present in memo
        return s in memo