class Solution:
    def countUnivalSubtrees(self, root: Optional[TreeNode]) -> int:
        def dfs(node):
            if node is None:
                return True, 0
            
            left = dfs(node.left)
            right = dfs(node.right)
            isLeftUniValue = left[0]
            isRightUniValue = right[0]
            count = left[1] + right[1]
            # If both the children form uni-value subtrees, we compare the value of
            # chidrens node with the node value.
            if isLeftUniValue and isRightUniValue:
                if node.left and node.val != node.left.val:
                    return False, count
                if node.right and node.val != node.right.val:
                    return False, count

                return True, count + 1
            # Else if any of the child does not form a uni-value subtree, the subtree
            # rooted at node cannot be a uni-value subtree.
            return False, count
        
        return dfs(root)[1]