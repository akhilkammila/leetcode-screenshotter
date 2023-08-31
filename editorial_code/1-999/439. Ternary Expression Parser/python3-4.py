class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None

class Solution:
    def parseTernary(self, expression: str) -> str:
        
        # Global Index to Construct Binary Tree
        self.index = 0
        root = self.constructTree(expression)
        
        # Parse the binary tree till we reach the leaf node
        while root.left and root.right:
            if root.val == 'T':
                root = root.left
            else:
                root = root.right
        
        return root.val

    def constructTree(self, expression):
        
        # Storing current character of expression
        root = TreeNode(expression[self.index])

        # If the last character of expression, return
        if self.index == len(expression) - 1:
            return root
        
        # Check the next character
        self.index += 1
        if expression[self.index] == '?':
            self.index += 1
            root.left = self.constructTree(expression)
            self.index += 1
            root.right = self.constructTree(expression)
            
        return root