class Solution:
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        answer = []
        
        def dfs(node):
            if not node:
                return
            # Visit root first, then the left subtree, then the right subtree.
            answer.append(node.val)
            dfs(node.left)
            dfs(node.right)
            
        dfs(root)
        return answer