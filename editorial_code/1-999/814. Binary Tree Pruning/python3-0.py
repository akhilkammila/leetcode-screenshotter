class Solution:
    def pruneTree(self, root: TreeNode) -> TreeNode:
        
        def contains_one(node: TreeNode) -> bool:
            if not node: 
                return False
            
            # Check if any node in the left subtree contains a 1.
            left_contains_one = contains_one(node.left)
            
            # Check if any node in the right subtree contains a 1.
            right_contains_one = contains_one(node.right)
            
            # If the left subtree does not contain a 1, prune the subtree.
            if not left_contains_one: 
                node.left = None
                
            # If the right subtree does not contain a 1, prune the subtree.
            if not right_contains_one: 
                node.right = None
            
            # Return True if the current node or its left or right subtree contains a 1.
            return node.val or left_contains_one or right_contains_one

        # Return the pruned tree if the tree contains a 1, otherwise return None.
        return root if contains_one(root) else None