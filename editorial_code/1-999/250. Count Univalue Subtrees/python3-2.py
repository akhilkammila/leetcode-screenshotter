class Solution:
    def countUnivalSubtrees(self, root: Optional[TreeNode]) -> int:
        def dfs(node, count):
            if node is None:
                return True

            isLeftUniValue = dfs(node.left, count)
            isRightUniValue = dfs(node.right, count)

            # If both the children form uni-value subtrees, we compare the value of
            # chidrens node with the node value.
            if isLeftUniValue and isRightUniValue:
                if node.left and node.val != node.left.val:
                    return False
                if node.right and node.val != node.right.val:
                    return False
    
                count[0] += 1
                return True
            # Else if any of the child does not form a uni-value subtree, the subtree
            # rooted at node cannot be a uni-value subtree.
            return False

        count = [0]
        dfs(root, count)
        return count[0]